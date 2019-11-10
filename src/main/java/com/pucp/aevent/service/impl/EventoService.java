package com.pucp.aevent.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IDivisionDao;
import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IPreguntaDao;
import com.pucp.aevent.dao.ISeccionDao;
import com.pucp.aevent.dao.IFormularioCFPDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IEventoService;

@Service
public class EventoService implements IEventoService {

	@Autowired
	IEventoDao dao;

	@Autowired
	IPersonaDao daoPersona;

	@Autowired
	IFormularioCFPDao daoFormaulario;

	@Autowired
	IDivisionDao daoDivision;

	@Autowired
	ISeccionDao daoSeccion;

	@Autowired
	IPreguntaDao daoPregunta;
	
	@Autowired
	IPropuestaDao daoPropuesta;
	
	@Autowired
	IEvaluacionDao daoEvaluacion;
	
	private Paginacion paginacion;

	public Paginacion getPaginacion() {
		return this.paginacion;
	}

	private Logger logger = LoggerFactory.getLogger(EventoService.class);

	private Error error;

	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional
	public Evento save(Evento evento) {
		Evento returnedEvento = null;
		Persona participante = null;
		try {
			participante = this.daoPersona.findByUsername(evento.getOrganizador().getUsername());
			evento.setOrganizador(participante);

			participante = this.daoPersona.findByUsername(evento.getPresidente().getUsername());
			evento.setPresidente(participante);
			
			returnedEvento = this.dao.save(evento);
		} catch (Exception ex) {
			logger.error("Error en el sistema: " + ex.getCause());
		}
		return returnedEvento;
	}

//	@Override
//	@Transactional(readOnly=true)
//	public List<Evento> findAll(Pageable page) {
//		Page<Evento> lista = null;
//		this.paginacion = new Paginacion();
//		this.paginacion.setPageable(page);
//		try {
//			lista = this.dao.findAll(page); 
//			this.paginacion.setTotalRegistros(lista.getTotalElements());
//		}catch(Exception e) {
//			System.out.print(e.getMessage());
//		}
//		return lista.getContent();
//	}

	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAllOrganizador(Persona persona, Pageable page) {
		Page<Evento> lista = null;
		/*
		 * Organizador
		 * */
		Persona organizador = null;
		
		organizador = this.daoPersona.findByUsername(persona.getUsername());
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findByOrganizador(organizador, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAllByPresidente(Persona persona, Pageable page) {
		Page<Evento> lista = null;
		/*
		 * Presidente
		 * */
		Persona presidente = null;
		
		presidente = this.daoPersona.findByUsername(persona.getUsername());
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findByPresidente(presidente, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAllByComite(Persona persona, Pageable page) {
		Page<Evento> lista = null;
		/*
		 * Evaluador
		 * */
		Persona evaluador = null;
		
		evaluador = this.daoPersona.findByUsername(persona.getUsername());
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findByComite(evaluador, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}

	@Override
	@Transactional(readOnly = true)
	public Evento findById(Integer id) {
		return this.dao.findByIdEvento(id);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Evento> findEnabled(Pageable page) {
		Page<Evento> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findByEnabled(true, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Propuesta> findAllPropuesta(Evento evento, Pageable page) {
		Page<Propuesta> lista = null;
		/*
		 * Organizador
		 * */
		//Persona organizador = null;
		
		//Evento evento = this.dao.findByIdEvento(idEvento);
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.daoPropuesta.findByEvento(evento, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
			for (Propuesta prop : lista.getContent()) {
				//prop.setPostulante(daoPersona.findByIdUsuario(prop.getPostulante().getIdUsuario()));
				List<Evaluacion> evaluaciones = daoEvaluacion.findByPropuesta(prop);
				Set<Persona> evaluadores = new HashSet<>();
				for (Evaluacion e : evaluaciones) {
					evaluadores.add(daoPersona.findByIdUsuario(e.getEvaluador().getIdUsuario()));
				}
				prop.setEvaluadoresAsignados(new ArrayList<>(evaluadores));
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Evaluacion> findAllOfEvaluador(Persona evaluador, Pageable page){
		Page<Evaluacion> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		//try {
			lista = this.daoEvaluacion.findByEvaluador(evaluador, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			/*
			for (Evaluacion e : lista.getContent())
				e.setPropuesta(this.daoPropuesta.findByIdPropuesta(e.getPropuesta().getIdPropuesta()));
			
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}*/
		return lista.getContent();
	}

	@Override
	public List<Evento> findAllEventos(Persona usuario, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
