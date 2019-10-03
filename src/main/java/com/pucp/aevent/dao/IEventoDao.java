package com.pucp.aevent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evento;

public interface IEventoDao extends JpaRepository<Evento, Long>{
	public Evento findByIdEvento(Integer id);	
}
