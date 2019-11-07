package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.RespuestaFormulario;

public interface IRespuestaFormularioService {
	public RespuestaFormulario save(RespuestaFormulario respuesta);
	public List<RespuestaFormulario> findByIdFaseAndIdPostulante(Long idFase, Long idPostulacion);
}
