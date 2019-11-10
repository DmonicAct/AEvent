package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IPersonaDao;
import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.TipoCriterio;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPreferenciaService;

@Service
public class PreferenciaService implements IPreferenciaService {
	@Autowired
	IPersonaDao daoPersona;
	@Autowired
	IPreferenciaDao dao;
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	
	@Override
	public Error getError() {
		return this.error;
	}

/*	@Override
	public List<Preferencia> findByUsuario(Usuario user) {
		return dao.findByUsuario(user);
	}*/
	@Override
	public List<Preferencia> findByUsuario(Persona usuario,Pageable page) {
		Page<Preferencia> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByUsuario(usuario, page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}
	
	
/*
	@Override
	public Preferencia findByUsuarioAndPropuesta(Usuario user,Propuesta prop) {
		return dao.findByUsuarioAndPropuesta(user,prop);
	}*/

}
