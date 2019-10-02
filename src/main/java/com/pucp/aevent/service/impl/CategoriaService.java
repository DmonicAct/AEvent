package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pucp.aevent.dao.ICategoriaDao;
import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	ICategoriaDao dao;
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(Categoria categoria) {
		this.dao.save(categoria);
	}
	
}
