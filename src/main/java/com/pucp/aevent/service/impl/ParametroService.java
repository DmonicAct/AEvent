package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.IParametroDao;
import com.pucp.aevent.entity.Parametro;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IParametroService;

@Service
public class ParametroService implements IParametroService{
	
	@Autowired
	IParametroDao dao;
	
	private Logger logger = LoggerFactory.getLogger(ParametroService.class);

	@Override
	@Transactional(readOnly=true)
	public List<Parametro> findAll(Pageable page) {
		Page<Parametro> lista = null;
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
	public List<Parametro> findByDescripcion(String descripcion){
		List<Parametro> lista = null;
		try {
			lista = dao.findByDescripcionCorta(descripcion);
		}catch(Exception e) {
			logger.error("Error en parametros :" + e.getMessage() + " en el sistema");
		}
		return lista;
	}
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
}
