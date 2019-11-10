package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.entity.Persona;

public interface IEvaluacionService {
	public Evaluacion asignarPropuesta(Persona evaluador,Propuesta propuesta,Fase fase);
	public void delete(Evaluacion evaluacion);
	public List<Evaluacion> findAllByEvaluador(Persona evaluador,Pageable page);
	public void save(Evaluacion e);
	public Paginacion getPaginacion();
}