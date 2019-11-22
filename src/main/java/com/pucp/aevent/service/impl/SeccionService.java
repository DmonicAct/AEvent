package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.ISeccionDao;
import com.pucp.aevent.entity.Pregunta;
import com.pucp.aevent.entity.Seccion;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IPreguntaService;
import com.pucp.aevent.service.ISeccionService;

@Service
public class SeccionService implements ISeccionService {
	
	@Autowired
	private ISeccionDao dao;
	
	@Autowired
	private IPreguntaService service;
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	private Logger logger = LoggerFactory.getLogger(SeccionService.class);
	
	@Override
	@Transactional
	public Seccion save(Seccion seccion) {
		Seccion sec = null;
		try {
			sec = this.dao.save(seccion);
			Long idSeccion = sec.getIdSeccion();
			List<Pregunta> listaPregunta = seccion.getPreguntaList();
			if(listaPregunta!=null && listaPregunta.size()>0)
				for(Pregunta item: listaPregunta) {
					item.setIdSeccion(idSeccion);
					this.service.save(item);
				}
		} catch (Exception e) {
			logger.error("Error en Division Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Division Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return sec;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Seccion> findByIdDivision(Long idDivision) {
		List<Seccion> lista = null;
		try {
			lista = this.dao.findByIdDivision(idDivision);
			for(Seccion seccion: lista) {
				Long idSeccion = seccion.getIdSeccion();
				if(idSeccion!=null) {
					List<Pregunta> listaPregunta = this.service.findByIdSeccion(idSeccion);
					seccion.setPreguntaList(listaPregunta);
				}
			}
		} catch (Exception e) {
			logger.error("Error en Division Service(findByIdDivision): " + e.getMessage());
			this.error.setMensaje("Error en Division Service(findByIdDivision): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return lista;
	}
	@Override
	@Transactional
	public void deleteByIdSeccion(Long idSeccion) {
		try {
			this.dao.deleteById(idSeccion);
		} catch (Exception e) {
			logger.error("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensaje("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
	}
}
