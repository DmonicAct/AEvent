package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.ICriterioDao;
import com.pucp.aevent.dao.IFaseDao;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Criterio;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.ICriterioService;

@Service
public class CriterioService implements ICriterioService{
	
	@Autowired
	ICriterioDao dao;
	
	@Autowired
	IFaseDao daoFase;
	
	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Criterio> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void save(Criterio criterio) {
		this.dao.save(criterio);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Criterio> findByFase(Long idFase) {
		List<Criterio> lista = null;
		try {
			lista = this.dao.findByIdFase(idFase);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return lista;
	}

	@Override
	@Transactional
	public void delete(Long criterio) {
		this.dao.deleteById(criterio);		
	}

	@Override
	@Transactional
	public void updateCriterio(Criterio criterio) {
		Criterio c = this.dao.findByIdCriterio(criterio.getIdCriterio());
		c.setDescripcion(criterio.getDescripcion());
		this.dao.save(c);
	}


}
