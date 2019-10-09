package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface ILugarService {
	Paginacion getPaginacion();
	Error getError();
	public List<Lugar> findAll();
	public Lugar guardarLugar(Lugar lugar);
	
}
