package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Preferencia;

public interface IPreferenciaService {
//	public List<Preferencia> findByUsuario(Usuario user);
	public List<Preferencia> findByIdUsuario(int idUsuario);
//	public Preferencia findByUsuarioAndPropuesta(Usuario user,Propuesta prop);
}
