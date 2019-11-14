package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPostulacionDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPostulacionService;

@Service
public class PostulacionService implements IPostulacionService{
	
	@Autowired
	IPostulacionDao dao;
	
	@Autowired
	IPropuestaDao daoPropuesta;
	
	@Autowired
	IEventoDao daoEvento;
	
	@Autowired
	IUsuarioDao daoUsuario;
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	private Logger logger = LoggerFactory.getLogger(PostulacionService.class);
	
	@Override
	public Postulacion save(Postulacion postulacion) {
		Postulacion post = null;
		try {
			post = this.dao.save(postulacion);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}

	@Override
	public Postulacion findById(Long idPostulacion, Long idEvento) {
		Postulacion post= null;
		try {
			post = this.dao.findByIdPostulacionAndIdEvento(idPostulacion, idEvento);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}
	
	@Override
	public List<Postulacion> findAll(Long idUsuario,Pageable page){
		Page<Postulacion> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByIdUsuario(idUsuario,page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		
		return lista.getContent();
	}
	
	@Override
	public Boolean existsPostulacion(Long idUsuario, Long idEvento) {
		Boolean post= null;
		try {
			post = this.dao.existsByIdUsuarioAndIdEvento(idUsuario,idEvento);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}
	
	@Override
	public Propuesta savePropuesta(Propuesta propuesta) {
		Propuesta prop= null;
		try {
			prop = this.daoPropuesta.save(propuesta);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(savePropuesta): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(savePropuesta): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return prop;
	}

	@Override
	public Boolean existsPropuesta(int idUsuario, int idEvento) {
		Usuario postulante = this.daoUsuario.findByIdUsuario(idUsuario);
		
		Evento evento = this.daoEvento.findByIdEvento(idEvento);
		Boolean exists = null;
		try {
			exists = this.daoPropuesta.existsByPostulanteAndEvento(postulante, evento);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(existsPropuesta): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(existsPropuesta): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return exists;
	}

	@Override
	public List<Propuesta> findAllPropuesta(Usuario usuario, Pageable page) {
		Page<Propuesta> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.daoPropuesta.findByPostulante(usuario,page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		
		return lista.getContent();
	}
	@Override
	public Propuesta findByPostulanteAndEvento(Usuario usuario,Evento evento) {
		Propuesta prop= null;
		try {
			prop = this.daoPropuesta.findByPostulanteAndEvento(usuario,evento);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return prop;
	}

	@Override
	public Propuesta findByIdPropuesta(Integer idPropuesta) {
		Propuesta prop= null;
		try {
			prop = this.daoPropuesta.findByIdPropuesta(idPropuesta);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return prop;
	}
}
