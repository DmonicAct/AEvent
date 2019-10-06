package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pucp.aevent.entity.TipoEvento;

public interface ITipoEventoDao extends JpaRepository<TipoEvento, Long> {
	//public Page List<TipoEvento> findAll(Pageable pageable);
}


