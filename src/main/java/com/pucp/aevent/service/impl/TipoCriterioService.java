package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.ITipoCriterioDao;
import com.pucp.aevent.entity.TipoCriterio;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.ITipoCriterioService;

@Service
public class TipoCriterioService implements ITipoCriterioService {

	@Autowired
	ITipoCriterioDao dao;
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoCriterio> findAll() {
		return this.dao.findAll();
	}

	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<TipoCriterio> findAll(Pageable page) {
		Page<TipoCriterio> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findAll(page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}

	@Override
	public void save(TipoCriterio tipoCategoria) {
		this.dao.save(tipoCategoria);		
	}


	
}
