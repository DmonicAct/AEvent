package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.service.IPreferenciaService;

@Service
public class PreferenciaService implements IPreferenciaService {
	IPreferenciaDao dao;
	@Override
	public List<Preferencia> findByIdUsuario(int idUsuario) {
		return dao.findByIdUsuario(idUsuario);
	}

	@Override
	public Preferencia findByIdUsuarioAndIdPropuesta(int idUsuario, int idPropuesta) {
		return dao.findByIdUsuarioAndIdPropuesta(idUsuario, idPropuesta);
	}

}
