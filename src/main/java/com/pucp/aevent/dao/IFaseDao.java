package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Evento;

public interface IFaseDao  extends JpaRepository <Fase, Long>{
	public List<Fase> findAll();
	
	public List<Fase> findByEvento(Evento evento);
	
	public Fase findByIdFase(Integer idFase);
	
	public Fase deleteByIdFase(Integer idFase);
}
