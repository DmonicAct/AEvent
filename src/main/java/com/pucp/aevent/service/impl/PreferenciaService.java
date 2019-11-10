package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.service.IPreferenciaService;

@Service
public class PreferenciaService implements IPreferenciaService {
	@Autowired
	IPersonaDao daoPersona;
	@Autowired
	IPreferenciaDao dao;
/*	@Override
	public List<Preferencia> findByUsuario(Usuario user) {
		return dao.findByUsuario(user);
	}*/
	@Override
	public List<Preferencia> findByUsuario(Persona usuario) {
		return dao.findByUsuario(usuario);
	}
	
	
/*
	@Override
	public Preferencia findByUsuarioAndPropuesta(Usuario user,Propuesta prop) {
		return dao.findByUsuarioAndPropuesta(user,prop);
	}*/

}
