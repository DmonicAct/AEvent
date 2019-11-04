package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IEventoService {
	public Evento save(Evento evento);
	//public List<Evento> findAll(Pageable page);
	public List<Evento> findAllOrganizador(Persona usuario, Pageable page);
	public Evento findById(Integer id);
	public List<Evento> findAllByPresidente(Persona usuario, Pageable page);
	public List<Propuesta> findAllPropuesta(Integer idEvento, Pageable page);
	public List<Evaluacion> findAllOfEvaluador(Integer idEvaluador, Pageable page);
	
	public Paginacion getPaginacion();
	public Error getError();
}
