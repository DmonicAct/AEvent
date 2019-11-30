package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface ILugarService {
	public List<Lugar> findAll(Pageable pageable);
	public List<Lugar> findAll();
	Paginacion getPaginacion();
	Error getError();
	public void save(Lugar lugar);
	public void delete(Lugar lugar);
	
	public List<Lugar> findByEnabled(Boolean enabled);
	public List<Lugar> findByEnabled(Boolean enabled, Pageable page);
	
	
	public List<Lugar> findByDescripcionContainingAndEnabled(String descripcion,boolean enabled,Pageable page);
}
