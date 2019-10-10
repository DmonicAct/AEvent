package com.pucp.aevent.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IDivisionDao;
import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IPreguntaDao;
import com.pucp.aevent.dao.ISeccionDao;
import com.pucp.aevent.dao.IFormularioCFPDao;
import com.pucp.aevent.entity.Division;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.FormularioCFP;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Pregunta;
import com.pucp.aevent.entity.Seccion;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IEventoService;

@Service
public class EventoService implements IEventoService{
	
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
		Persona organizador=null;
		try {
			organizador = this.daoPersona.findByUsername(evento.getOrganizador().getUsername());
			evento.setOrganizador(organizador);
			
			returnedEvento = this.dao.save(evento);
			FormularioCFP formulario = returnedEvento.getFormulario();
			formulario = this.daoFormaulario.save(formulario);
			returnedEvento.setFormulario(formulario);
//			for(Division division : returnedEvento.getFormulario().getDivisionList()) {
//				division.setIdDivision(returnedEvento.getFormulario().getIdFormularioCFP());
//				this.daoDivision.save(division);
//				Division div = new Division();
//				div.setIdDivision(division.getIdDivision());
//				for(Seccion seccion: division.getSeccionList()) {
//					seccion.setIdDivision(div);
//					this.daoSeccion.save(seccion);
//					Seccion sub = new Seccion();
//					sub.setIdSeccion(seccion.getIdSeccion());
//					for(Pregunta pregunta :seccion.getPreguntaList()) {
//						pregunta.setIdSeccion(sub);
//						this.daoPregunta.save(pregunta);
//					}
//				}
//			}
		}catch(Exception ex) {
			logger.error("Error en el sistema: " + ex.getCause());
		}
		return returnedEvento;
	}

	@Override
	@Transactional(readOnly=true)
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
	@Transactional(readOnly = true)
	public Evento findById(Integer id) {
		return this.dao.findByIdEvento(id);
	}
}
