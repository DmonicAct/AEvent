package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Parametro;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IParametroService {
	public List<Parametro> findAll(Pageable pageable);
	
	public List<Parametro> findByDescripcion(String descripcion);
	Paginacion getPaginacion();
	Error getError();
}
