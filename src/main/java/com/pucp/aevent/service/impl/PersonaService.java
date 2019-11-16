package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	IPersonaDao dao;
	
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
	public List<Persona> findByNombreLike(String nombre) {
		return dao.findNombreLike(nombre);
	}

	@Override
	public List<Persona> findByUsernameLike(String username,Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findUsernameLike(username, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	public List<Persona> findNombreLike(String nombre, Pageable page) {
		Page<Persona> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findNombreLike(nombre, page);
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
