package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Division;

public interface IDivisionDao extends JpaRepository<Division, Long>{
	public List<Division> findByIdFormulariocfp(Long idFormularioCFP);
}
