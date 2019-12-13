package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.RespuestaCriterio;

public interface IRespuestaCriterioService {
	
	public List<RespuestaCriterio> findByCriterio(int id);
	
	public RespuestaCriterio save(RespuestaCriterio respuestaCriterio);
	
	public List<RespuestaCriterio> findByIdEvaluador(int idEvaluador, int idCriterio);
}
