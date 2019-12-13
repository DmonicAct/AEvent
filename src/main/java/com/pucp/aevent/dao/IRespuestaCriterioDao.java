package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.RespuestaCriterio;

public interface IRespuestaCriterioDao extends JpaRepository<RespuestaCriterio, Long> {
	public List<RespuestaCriterio> findByIdCriterio(int id);
	
	public List<RespuestaCriterio> findByIdCriterioAndIdEvaluador(int idCriterio, int idEvaluador);
	
}
