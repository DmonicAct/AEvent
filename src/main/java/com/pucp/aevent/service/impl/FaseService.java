package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IFaseDao;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.IFaseService;

@Service
public class FaseService implements IFaseService{
	
	@Autowired
	IFaseDao dao;
	
	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Fase> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void save(Fase fase) {
		this.dao.save(fase);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Fase> findByEvento(Evento evento) {
		return this.dao.findByIdEvento(evento);
	}

	@Override
	@Transactional
	public void delete(Long fase) {
		try {
			this.dao.deleteById(fase);
		}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Fase findByIdFase(Long id) {
		return this.dao.findByIdFase(id);
	}
	
}
