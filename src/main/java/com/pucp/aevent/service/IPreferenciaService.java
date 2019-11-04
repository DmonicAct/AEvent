package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Preferencia;

public interface IPreferenciaService {
	public List<Preferencia> findByIdUsuario(int idUsuario);
	public Preferencia findByIdUsuarioAndIdPropuesta(int idUsuario,int idPropuesta);
}
