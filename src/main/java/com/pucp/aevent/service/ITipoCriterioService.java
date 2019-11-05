package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.TipoCriterio;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface ITipoCriterioService {
	Error getError();
	public List<TipoCriterio> findAll();
	
	public List<TipoCriterio> findAll(Pageable pageable);
	
	Paginacion getPaginacion();
	
	public void save(TipoCriterio tipoCategoria); 
}
