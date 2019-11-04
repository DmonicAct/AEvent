package com.pucp.aevent.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IFormularioCFPDao;
import com.pucp.aevent.entity.FormularioCFP;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IFormularioCFPService;

@Service
public class FormularioCFPService implements IFormularioCFPService{
	
	@Autowired
	IFormularioCFPDao dao;
	
	private Error error;

	@Override
	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional
	public void save(FormularioCFP formularioCFP) {
		this.dao.save(formularioCFP);
	}
}
