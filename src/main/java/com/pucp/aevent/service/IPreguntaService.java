package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Pregunta;

public interface IPreguntaService {
	public Pregunta save(Pregunta pregunta);
	
	public List<Pregunta> findByIdSeccion(Long idSeccion);
	
	public void deleteByIdPregunta(Long idPregunta);
}
