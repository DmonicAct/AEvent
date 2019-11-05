package com.pucp.aevent.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evaluacion;

public interface IEvaluacionDao  extends JpaRepository <Evaluacion, Long>{
	public Page<Evaluacion> findByIdEvaluador(Integer idEvaluador, Pageable page);
	public Evaluacion findByIdEvaluadorAndIdPropuestaAndIdFase(Integer idEvaluador,Integer idPropuesta,Integer idFase);
}