package com.pucp.aevent.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	IPersonaDao dao;
	
	@Autowired
	IEventoDao daoEvento;
	
	@Autowired
	IUsuarioDao daoUsuario;
	
	private Paginacion paginacion;
	
	
	
	public Paginacion getPaginacion() {
		return paginacion;
	}

	public void setPaginacion(Paginacion paginacion) {
		this.paginacion = paginacion;
	}

	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		return dao.findByEnabled(true);
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		this.dao.save(persona);
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findByUsername(String username) {
		return this.dao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombre(String nombre) {
		return dao.findByNombreStartsWith(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByNombre(Integer id,String nombre, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> comite = e.getComite();
			List<Integer> idsComite = new ArrayList<Integer>();
			for (Usuario u: comite) {
				idsComite.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsComite,"ROLE_ADMIN",true);
			
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findByUsername(Integer id,String username,Pageable page) {
		Page<Persona> lista = null;
		boolean flagAdmin = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> comite = e.getComite();
			List<Integer> idsComite = new ArrayList<Integer>();
			for (Usuario u: comite) {
				idsComite.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsComite,"ROLE_ADMIN",true);
			//List<Persona> listaUsuarios= dao.findByIdUsuarioNotIn(idsComite);
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getUsername().toLowerCase().contains(username.toLowerCase())) {
					ids.add(u.getIdUsuario());
				}
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAllDisponible(Integer id, Pageable page) {
		Page<Persona> lista = null;
		Boolean flag = false;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			List<Usuario> listaUsuarios = e.getComite();
			HashSet<Integer> ids = new HashSet<Integer>();
			for (Usuario u: listaUsuarios) {	
				ids.add(u.getIdUsuario());
			}	
			//Buscamos administradores
			listaUsuarios = daoUsuario.findByRoles_nombreAndEnabled("ROLE_ADMIN", true);
			for (Usuario u: listaUsuarios) {	
				ids.add(u.getIdUsuario());
			}	
			List<Integer> listaIDs = new ArrayList<>(ids); 
			lista = dao.findByEnabledAndIdUsuarioNotIn(true,listaIDs, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAllComite(Integer id, Pageable page) {
		Page<Persona> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			List<Usuario> listaUsuarios = e.getComite();
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) 
				ids.add(u.getIdUsuario());
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	public List<Persona> findByEmail(Integer id,String email, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			Evento e = daoEvento.findByIdEvento(id);
			
			List<Usuario> comite = e.getComite();
			List<Integer> idsComite = new ArrayList<Integer>();
			for (Usuario u: comite) {
				idsComite.add(u.getIdUsuario());
			}
			
			List<Persona> listaUsuarios= dao.findByIdUsuarioNotInAndRoles_nombreNotAndEnabled(idsComite,"ROLE_ADMIN",true);
			
			
			List<Integer> ids = new ArrayList<Integer>();
			for (Usuario u: listaUsuarios) {
				if(u.getEmail().toLowerCase().contains(email.toLowerCase()))
					ids.add(u.getIdUsuario());
			}
				
			lista = dao.findByIdUsuarioIn(ids, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
//	@Override
//	@Transactional(readOnly=true)
//	public Boolean existsByDni(String dni) {
//		return this.dao.existsByDni(dni);
//	}

}
