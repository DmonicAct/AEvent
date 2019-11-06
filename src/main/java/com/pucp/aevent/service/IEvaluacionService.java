package com.pucp.aevent.service;

import com.pucp.aevent.entity.Evaluacion;

public interface IEvaluacionService {
	public Evaluacion save(Integer idEvaluador,Integer idPropuesta,Integer idFase);
}
