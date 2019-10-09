package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	IPersonaDao dao;
	
	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		this.dao.save(persona);
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findByUsername(String username) {
		return this.dao.findByUsername(username);
	}
	
	

}
