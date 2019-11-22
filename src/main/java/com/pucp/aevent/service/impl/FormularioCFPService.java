package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IFormularioCFPDao;
import com.pucp.aevent.entity.Division;
import com.pucp.aevent.entity.FormularioCFP;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IDivisionService;
import com.pucp.aevent.service.IFormularioCFPService;

@Service
public class FormularioCFPService implements IFormularioCFPService{
	
	@Autowired
	private IFormularioCFPDao dao;
	
	@Autowired
	private IDivisionService service;
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	private Logger logger = LoggerFactory.getLogger(FormularioCFPService.class);

	@Override
	@Transactional
	public void save(FormularioCFP formularioCFP) {
		FormularioCFP formulario = null;
		try {
			formulario = this.dao.save(formularioCFP);
			Long idFormulario = formulario.getIdFormulariocfp();
			List<Division> listaDivision = formularioCFP.getDivisionList();
			if(listaDivision!=null && listaDivision.size()>0)
				for(Division item: listaDivision) {
					item.setIdFormulariocfp(idFormulario);
					this.service.save(item);
				}
		} catch (Exception e) {
			logger.error("Error en Formulario Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Formulario Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FormularioCFP findByIdFormularioCFP(Long idFormularioCFP) {
		FormularioCFP formulario = null;
		try {
			this.dao.findById(idFormularioCFP);
		} catch (Exception e) {
			logger.error("Error en Formulario Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Formulario Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return formulario;
	}
	
	
	
}
