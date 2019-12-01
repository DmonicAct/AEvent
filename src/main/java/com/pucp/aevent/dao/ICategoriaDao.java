package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Persona;


public interface ICategoriaDao extends JpaRepository <Categoria, Long>{
	public List<Categoria> findAll();

	public Page<Categoria> findAll(Pageable pageable);
	
	public List<Categoria> findByEnabled(Boolean enabled);
	
	public Page<Categoria> findByEnabled(Boolean enabled, Pageable page);
	
	public Page<Categoria> findByDescripcionContainingAndEnabled(String descripcion,boolean enabled,Pageable page);

	public List<Categoria> findByDescripcionContaining(String descripcion);
}
