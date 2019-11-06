package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IErrorLogDao;
import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.ErrorLog;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IErrorLogService;

@Service
public class ErrorLogService implements IErrorLogService{

	@Autowired
	IErrorLogDao dao;
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ErrorLog> findAll() {
		return null;
	}

	private Paginacion paginacion;
	
	@Override
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<ErrorLog> findAll(Pageable page) {
		Page<ErrorLog> lista = null;
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
	@Transactional
	public void save(ErrorLog error) {
		this.dao.save(error);
		
	}
}
