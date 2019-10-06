package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.ITipoEventoDao;
import com.pucp.aevent.entity.TipoEvento;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Nivel;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.ITipoEventoService;

@Service
public class TipoEventoService implements ITipoEventoService{

	@Autowired
	ITipoEventoDao dao;
	
	@Override
	public List<TipoEvento> findAll(Pageable page) {
		Page<TipoEvento> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findAll(page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		return lista.getContent();
		
	}
	
	@Override
	public List<TipoEvento> findAll() {
		List<TipoEvento> lista =null;
		try {
			lista = dao.findAll();
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		return lista;
		
	}
	
	private Paginacion paginacion;
	@Override
	public Paginacion getPaginacion() {
		return this.paginacion;
	}

	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	@Override
	public TipoEvento guardarTipoEvento(TipoEvento tipoEvento) {
		Integer success = 1;
		TipoEvento returnedObject = null;
		try {
			returnedObject = this.dao.save(tipoEvento);
		}catch(Exception ex) {
			success = 0;
			this.error = new Error(success,ex.getCause().toString(),ex.getMessage(),Nivel.SERVICE);
			return returnedObject;
		}
		return returnedObject;
	}
	
}
