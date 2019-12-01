package com.pucp.aevent.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;

import java.util.*;

public interface IPropuestaDao extends JpaRepository<Propuesta, Long> {
	//@Query("SELECT P FROM propuesta P WHERE P.id_evento = ?1")
	public Page<Propuesta> findByEvento(Evento evento, Pageable page);
	
	public Page<Propuesta> findByEstadoAndEventoIn(String estado, List<Evento> lista, Pageable page);
	public List<Propuesta> findByEstadoAndEventoIn(String estado, List<Evento> lista);
	/*
	 * 
	 * public Page<Persona> findByEnabledAndIdUsuarioNotIn(Boolean enabled, List<Integer> ids,Pageable page);
	 * 
	 * */
	
	public List<Propuesta> findByEventoAndEstado(Evento evento,String estado);
	public Propuesta findByIdPropuesta(Integer idPropuesta);
	
	Boolean existsByPostulanteAndEvento(Usuario postulante,Evento evento);
	public Page<Propuesta> findByPostulante(Usuario postulante, Pageable page);
	public Propuesta findByPostulanteAndEvento(Usuario postulante,Evento evento);
	
	public Page<Propuesta> findByPostulanteAndEvento(Usuario postulante, Evento evento,Pageable page);
	public Page<Propuesta> findByTituloAndEvento(String titulo, Evento evento,Pageable page);
	
	public List<Propuesta> findByEstado(String estado);
	public Page<Propuesta> findByEstado(String estado,Pageable page);
	
	public List<Propuesta> findByIdPropuestaIn(List<Integer> lista);
}