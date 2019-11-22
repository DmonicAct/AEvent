package com.pucp.aevent.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IPreguntaDao;
import com.pucp.aevent.entity.Pregunta;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IPreguntaService;

@Service
public class PreguntaService implements IPreguntaService {
	
	@Autowired
	private IPreguntaDao dao;
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	private Logger logger = LoggerFactory.getLogger(PreguntaService.class);
	
	@Override
	@Transactional
	public Pregunta save(Pregunta pregunta) {
		Pregunta preg = null;
		try {
			preg = this.dao.save(pregunta);
		} catch (Exception e) {
			logger.error("Error en Pregunta Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Pregunta Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return preg;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pregunta> findByIdSeccion(Long idSeccion) {
		List<Pregunta> lista = null;
		try {
			lista = this.dao.findByIdSeccion(idSeccion);
		} catch (Exception e) {
			logger.error("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensaje("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return lista;
	}
	
	@Override
	@Transactional
	public void deleteByIdPregunta(Long idPregunta) {
		try {
			this.dao.deleteById(idPregunta);
		} catch (Exception e) {
			logger.error("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensaje("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
	}
}
