package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Categoria;


public interface ICategoriaDao extends JpaRepository <Categoria, Long>{
	public List<Categoria> findAll();

	public Page<Categoria> findAll(Pageable pageable);
	
}
