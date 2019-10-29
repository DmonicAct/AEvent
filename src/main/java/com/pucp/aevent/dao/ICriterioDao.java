package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Criterio;

public interface ICriterioDao  extends JpaRepository <Criterio, Long>{
	public List<Criterio> findAll();
	
	public List<Criterio> findByFase(Fase fase);
	
}
