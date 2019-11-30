package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.TipoEvento;

public interface ITipoEventoDao extends JpaRepository<TipoEvento, Long> {
	//public Page List<TipoEvento> findAll(Pageable pageable);
	public TipoEvento findByIdTipoEvento(Integer id);	
	
	public List<TipoEvento> findByEnabled(Boolean enabled);
	
	
	public Page<TipoEvento> findByEnabled(Boolean enabled, Pageable page);
	
	public Page<TipoEvento> findByNombreContainingAndEnabled(String descripcion,boolean enabled,Pageable page);
}