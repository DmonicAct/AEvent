package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IDivisionDao;
import com.pucp.aevent.entity.Division;
import com.pucp.aevent.entity.Pregunta;
import com.pucp.aevent.entity.Seccion;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IDivisionService;
import com.pucp.aevent.service.ISeccionService;

@Service
public class DivisionService implements IDivisionService{
	
	@Autowired
	private IDivisionDao dao;
	
	@Autowired
	private ISeccionService service;
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	private Logger logger = LoggerFactory.getLogger(DivisionService.class);
	
	@Override
	@Transactional
	public Division save(Division division) {
		Division div = null;
		try {
			div = this.dao.save(division);
			Long idDivision = div.getIdDivision();
			List<Seccion> listaSeccion = division.getSeccionList();
			if(listaSeccion!=null && listaSeccion.size()>0)
				for(Seccion item: listaSeccion) {
					item.setIdDivision(idDivision);
					this.service.save(item);
				}
		} catch (Exception e) {
			logger.error("Error en Division Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Division Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return div;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Division> findByIdFormulario(Long idFormulario) {
		List<Division> lista = null;
		try {
			lista = this.dao.findByIdFormulariocfp(idFormulario);
			for(Division division: lista) {
				Long idDivision = division.getIdDivision();
				if(idDivision!=null) {
					List<Seccion> listaSeccion = this.service.findByIdDivision(idDivision);
					division.setSeccionList(listaSeccion);
				}
			}
		} catch (Exception e) {
			logger.error("Error en Division Service(findByIdFormulario): " + e.getMessage());
			this.error.setMensaje("Error en Division Service(findByIdFormulario): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return lista;
	}
	@Override
	@Transactional
	public void deleteByIdDivision(Long idDivision) {
		try {
			this.dao.deleteById(idDivision);
		} catch (Exception e) {
			logger.error("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensaje("Error en Pregunta Service(findByIdSeccion): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
	}
}
