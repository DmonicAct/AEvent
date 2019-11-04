package com.pucp.aevent.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evaluacion;

public interface IEvaluacionDao  extends JpaRepository <Evaluacion, Long>{
	Page<Evaluacion> findByIdEvaluador(Integer idEvaluador, Pageable page);
}