package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IPropuestaService{
	List<Propuesta> findAllByEspera(int idPresidente);
	List<Propuesta> findAllByEsperaPag(int idPresidente, Pageable page);
	
	public List<Propuesta> findByPostulanteAndEvento(Usuario postulante, Evento evento,Pageable page);
	public List<Propuesta> findByTituloAndEvento(String titulo, Evento evento,Pageable page);
	Error getError();
	Paginacion getPaginacion();
}
