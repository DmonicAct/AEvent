package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pucp.aevent.entity.Propuesta;

public interface IPropuestaDao extends JpaRepository<Propuesta, Long> {
	//@Query("SELECT P FROM propuesta P WHERE P.id_evento = ?1")
	public Page<Propuesta> findByIdEvento(Integer idevento, Pageable page);
}