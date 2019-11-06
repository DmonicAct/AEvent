package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Evaluacion;

public interface IEvaluacionService {
	public Evaluacion save(Integer idEvaluador,Integer idPropuesta,Integer idFase);
	public Integer delete(Integer idEvaluaacion);
	public List<Evaluacion> listarEvaluacionesDeEvaluador(Integer IdEvaluador,Pageable page);
}