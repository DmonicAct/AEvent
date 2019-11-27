package com.pucp.aevent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pucp.aevent.entity.Correo;

public interface ICorreoDao extends JpaRepository <Correo, Long>{
	public Correo save(Correo correo);
	public Correo findByIdCorreo(Integer id);
}