package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.ILugarDao;
import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.ILugarService;

@Service
public class LugarService implements ILugarService{

	@Autowired
	ILugarDao dao;
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Lugar> findAll() {
		return dao.findByEnabled(true);
	}

	@Override 
	public void save(Lugar lugar) {
		this.dao.save(lugar);
	}
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	public List<Lugar> findAll(Pageable page) {
		Page<Lugar> lista = null;
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
	public void delete(Lugar lugar) {
		this.dao.delete(lugar);
	}
	
	@Override
	public List<Lugar> findByEnabled(Boolean enabled) {
		return dao.findByEnabled(enabled);
	}

	@Override
	public List<Lugar> findByEnabled(Boolean enabled, Pageable page) {
		Page<Lugar> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByEnabled(enabled, page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}
}
