package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Categoria;

import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface ICategoriaService {
	Error getError();
	public List<Categoria> findAll();
	
	public List<Categoria> findAll(Pageable pageable);
	
	Paginacion getPaginacion();
	
	public void save(Categoria categoria);  
}
