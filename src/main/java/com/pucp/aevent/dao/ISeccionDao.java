package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Seccion;

public interface ISeccionDao extends JpaRepository<Seccion, Long>{
	public List<Seccion> findByIdDivision(Long idDivision);
}
