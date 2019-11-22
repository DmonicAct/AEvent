package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Seccion;

public interface ISeccionService {
	public Seccion save(Seccion seccion);
	
	public List<Seccion> findByIdDivision(Long idDivision);
	
	public void deleteByIdSeccion(Long idSeccion);
}
