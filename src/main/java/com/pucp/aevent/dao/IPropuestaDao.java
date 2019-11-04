package com.pucp.aevent.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Propuesta;

public interface IPropuestaDao extends JpaRepository<Propuesta, Long> {
	public Page<Propuesta> findAllByIdEvento(Integer idevento, Pageable page);
}