package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Parametro;
public interface IParametroDao extends JpaRepository <Parametro, Long>{
	public List<Parametro> findAll();
	public List<Parametro> findByDescripcionCorta(String descripcion);
}
