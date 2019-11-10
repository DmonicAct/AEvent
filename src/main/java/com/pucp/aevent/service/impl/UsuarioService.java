package com.pucp.aevent.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IRolDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Role;
import com.pucp.aevent.entity.TipoEvento;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Nivel;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IUsuarioService;
import com.pucp.aevent.util.UtilConstanst;
@Service
public class UsuarioService implements IUsuarioService,UserDetailsService{
	
	@Autowired
	IUsuarioDao dao;
	
	@Autowired
	IRolDao role_dao;
	
	@Autowired
	IPersonaDao persona_dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = dao.findByUsername(username);
		
		if(usuario==null) {
			logger.error("Error en el login: No existe el usuario " + username + " en el sistema");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority( role.getNombre() ))
				.peek(authority -> logger.info("Role : " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true,true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Integer id) {
		Usuario user = dao.findByIdUsuario(id);
		user.setPassword(null);
		return  user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll(Pageable page) {
		//List<Object[]> lista2 = dao.findAll3("","",0,"","","",0);
		//List<Object[]> lista = dao.findAll2();
		Page<Usuario> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findAll(page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

	@Override
	@Transactional
	public Usuario save(Persona persona) {
		Usuario usuario = (Usuario)persona;
		Integer success = 1;
		Usuario returnedUser = null;
		try {
			if(usuario.getPassword()!=null  && usuario.getPassword()!="") {
				String passwordBcrypt = passwordEncoder.encode(usuario.getPassword());
				usuario.setPassword(passwordBcrypt);
			}else {
				usuario.setPassword(null);
			}
			List<Role> roles = new ArrayList<Role>();
			 for(Role entry :usuario.getRoles()) 
				    roles.add(role_dao.findById(entry.getId()).get());
			 
			usuario.setRoles( roles );
			if(usuario.getRoles().size()==0) {
				usuario.setEnabled(false);
			}
			returnedUser = dao.save(usuario);
			if(usuario.getIdUsuario()==0) {
				persona.setIdUsuario(returnedUser.getIdUsuario());
			}
			this.persona_dao.save(persona);
		}catch(Exception ex) {
			logger.error("Error en el sistema: " + ex.getMessage());
			success = 0;
			this.error = new Error(success,ex.getCause().toString(),ex.getMessage(),Nivel.SERVICE);
			return returnedUser;
		}
		return returnedUser;
	}
	
	@Override
	@Transactional
	public void cambioUsuario(Usuario usuario) {
		Integer success = 1;
		try {
			if(usuario.getPassword()!=null  && usuario.getPassword()!="") {
				String passwordBcrypt = passwordEncoder.encode(usuario.getPassword());
				usuario.setPassword(passwordBcrypt);
			}
			dao.save(usuario);
		}catch(Exception ex) {
			logger.error("Error en el sistema: " + ex.getMessage());
			success = 0;
			this.error = new Error(success,ex.getCause().toString(),ex.getMessage(),Nivel.SERVICE);
			return;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Boolean existsByEmail(String email) {
		return dao.existsByEmail(email);
	}

	@Override
	@Transactional(readOnly=true)
	public Boolean existsByUsername(String username) {
		return dao.existsByUsername(username);
	}
	
	@Override
	@Transactional
	public Usuario saveOut(Persona persona) {
		persona.setRoles(null);
		Usuario usuario = (Usuario)persona;
		Usuario returnedUser = null;
		try {
			if(usuario.getPassword()!=null  && usuario.getPassword()!="") {
				String passwordBcrypt = passwordEncoder.encode(usuario.getPassword());
				usuario.setPassword(passwordBcrypt);
			}else {
				throw new Exception("Password vacio");
			}
			long id_role_basic = UtilConstanst.ROLE_DEFAULT;
			List<Role> roles = new ArrayList<Role>();
			roles.add(role_dao.findById(id_role_basic).get());
			usuario.setRoles( roles );
			returnedUser = dao.save(usuario);
			if(usuario.getIdUsuario()==0) {
				persona.setIdUsuario(returnedUser.getIdUsuario());
			}
			this.persona_dao.save(persona);
		}catch(Exception ex) {
			return null;
		}
		return returnedUser;
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> lista =null;
		try {
			lista = dao.findByEnabled(true);
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		return lista;
	}
	
	
}
