package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Pregunta;

public interface IPreguntaDao extends JpaRepository <Pregunta, Long>{
	public List<Pregunta> findAll();
	
}
