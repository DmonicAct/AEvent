package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.TipoCriterio;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPreferenciaService;

@Service
public class PreferenciaService implements IPreferenciaService {
	@Autowired
	IPersonaDao daoPersona;
	
	@Autowired
	IPropuestaDao daoPropuesta;
	
	@Autowired
	IPreferenciaDao dao;
	
	private Logger logger = LoggerFactory.getLogger(EventoService.class);
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

/*	@Override
	public List<Preferencia> findByUsuario(Usuario user) {
		return dao.findByUsuario(user);
	}*/
	@Override
	public List<Preferencia> findByUsuario(Persona usuario,Pageable page) {
		Page<Preferencia> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByUsuario(usuario, page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}


	
	@Override
	@Transactional
	public Preferencia save(Preferencia preferencia) {
		Preferencia returnedPreferencia = null;
		Propuesta propuesta = null;
		Persona usuario = null;
		try {
			usuario = this.daoPersona.findByUsername(preferencia.getUsuario().getUsername());
			preferencia.setUsuario(usuario);

			propuesta = this.daoPropuesta.findByIdPropuesta(preferencia.getPropuesta().getIdPropuesta());
			preferencia.setPropuesta(propuesta);
			
			returnedPreferencia= this.dao.save(preferencia);
		} catch (Exception ex) {
			logger.error("Error en el sistema: " + ex.getCause());
		}
		return returnedPreferencia;
	}
	
/*
	@Override
	public Preferencia findByUsuarioAndPropuesta(Usuario user,Propuesta prop) {
		return dao.findByUsuarioAndPropuesta(user,prop);
	}*/

}
