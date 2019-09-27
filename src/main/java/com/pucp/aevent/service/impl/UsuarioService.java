package com.pucp.aevent.service.impl;

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

import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Nivel;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService{
	
	@Autowired
	IUsuarioDao dao;
	
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
	public Usuario findById(Integer id) {
		Usuario user = dao.findByIdUsuario(id);
		user.setPassword(null);
		return  user;
	}
	
	@Override
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
	public void save(Usuario usuario) {
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
}
