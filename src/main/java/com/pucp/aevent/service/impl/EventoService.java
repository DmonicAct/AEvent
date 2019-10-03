package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IEventoService;

@Service
public class EventoService implements IEventoService{
	
	@Autowired
	IEventoDao dao;
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	
	@Override
	public Evento save(Evento evento) {
		return this.dao.save(evento);
	}

	@Override
	public List<Evento> findAll(Pageable page) {
		Page<Evento> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findAll(page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	public Evento findById(Integer id) {
		return this.dao.findByIdEvento(id);
	}
}
