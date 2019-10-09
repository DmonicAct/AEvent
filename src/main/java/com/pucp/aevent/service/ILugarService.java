package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

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
}
