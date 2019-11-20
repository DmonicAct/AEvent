package com.pucp.aevent.dao;

import com.pucp.aevent.entity.RespuestaFormulario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRespuestaFormularioDao extends JpaRepository<RespuestaFormulario, Long> {
	
	List<RespuestaFormulario> findByIdPostulacion(Long idPostulacion); 
}
