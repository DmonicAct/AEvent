package com.pucp.aevent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.service.IEvaluacionService;

@Service
public class EvaluacionService implements IEvaluacionService{
	@Autowired IEvaluacionDao dao;
	
	public Evaluacion save(Integer idEvaluador,Integer idPropuesta,Integer idFase) {
		Evaluacion e = dao.findByIdEvaluadorAndIdPropuestaAndIdFase(idEvaluador,idPropuesta,idFase);
		if (e == null) {
			e = new Evaluacion();
			e.setEvaluado(false);
			e.setIdEvaluador(idEvaluador);
			e.setIdFase(idFase);
			e.setIdPropuesta(idPropuesta);
			e.setOpinion("");
			e.setVeredicto("");
			e = dao.save(e);
			return e;
		}
		return null;
	}
}