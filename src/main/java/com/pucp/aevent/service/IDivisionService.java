package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Division;

public interface IDivisionService {
	public Division save(Division division);
	
	public List<Division> findByIdFormulario(Long idFormulario);
	
	public void deleteByIdDivision(Long idDivision);
}
