package com.pucp.aevent.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Propuesta;

public interface IPropuestaDao extends JpaRepository<Propuesta, Long> {
	//@Query("SELECT P FROM propuesta P WHERE P.id_evento = ?1")
	public Page<Propuesta> findByEvento(Evento evento, Pageable page);
	public Propuesta findByIdPropuesta(Integer id);
}