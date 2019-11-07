package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IRespuestaFormularioDao;
import com.pucp.aevent.entity.RespuestaFormulario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IRespuestaFormularioService;

@Service
public class RespuestaFormularioService implements IRespuestaFormularioService{
	
	@Autowired
	private IRespuestaFormularioDao dao;
	
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
	public RespuestaFormulario save(RespuestaFormulario respuesta) {
		RespuestaFormulario rpta = null;
		try {
			rpta = this.dao.save(respuesta);
		} catch (Exception e) {
			logger.error("Error en RespuestaFormulario Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en RespuestaFormulario Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return rpta;
	}

	@Override
	public List<RespuestaFormulario> findByIdFaseAndIdPostulante(Long idFase, Long idPostulacion) {
		List<RespuestaFormulario> post= null;
		try {
			post = this.dao.findByIdFaseAndIdPostulacion(idFase, idPostulacion);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}

}
