package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.response_objects.Error;

public interface ICategoriaService {
	Error getError();
	public List<Categoria> findAll();
	
	public void save(Categoria categoria);
}
