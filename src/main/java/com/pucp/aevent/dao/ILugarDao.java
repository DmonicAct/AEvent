package com.pucp.aevent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pucp.aevent.entity.Lugar;

public interface ILugarDao extends JpaRepository<Lugar, Long> {
	//public Page List<TipoEvento> findAll(Pageable pageable);
	public Lugar findById(Integer id);	
	
	public List<Lugar> findByEnabled(Boolean enabled);
}


