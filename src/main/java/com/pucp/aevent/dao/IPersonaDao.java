package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Persona;
public interface IPersonaDao  extends JpaRepository <Persona, Long>{
	public List<Persona> findAll();
	
	public Persona findByUsername(String username);
	
	public Persona findByIdUsuario(int idUsuario);
	
	public List<Persona> findByEnabled(Boolean enabled);
}
