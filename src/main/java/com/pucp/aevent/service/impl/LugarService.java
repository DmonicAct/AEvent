package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.ILugarDao;
import com.pucp.aevent.entity.Lugar;
import com.pucp.aevent.entity.TipoEvento;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Nivel;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.ILugarService;

@Service
public class LugarService implements ILugarService {

	@Autowired
	ILugarDao dao;
	
	@Override
	public List<Lugar> findAll() {
		List<Lugar> lista =null;
		try {
			lista = dao.findAll();
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		return lista;
	}

	private Paginacion paginacion;
	@Override
	public Paginacion getPaginacion() {
		return this.paginacion;
	}

	private Error error;
	@Override
	public Error getError() {
		return this.error;
	}
	@Override
	public Lugar guardarLugar(Lugar lugar) {
		Integer success = 1;
		Lugar returnedObject = null;
		try {
			returnedObject = this.dao.save(lugar);
		}catch(Exception ex) {
			success = 0;
			this.error = new Error(success,ex.getCause().toString(),ex.getMessage(),Nivel.SERVICE);
			return returnedObject;
		}
		return returnedObject;
	}

}
