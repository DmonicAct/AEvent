package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IEventoService {
	public Evento save(Evento evento);
	//public List<Evento> findAll(Pageable page);
	public List<Evento> findAll(Persona usuario, Pageable page);
	public Evento findById(Integer id);
	
	public Paginacion getPaginacion();
	public Error getError();
}
