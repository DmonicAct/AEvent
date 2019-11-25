package com.pucp.aevent.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPropuestaService;
import com.pucp.aevent.util.UtilConstanst;

@Service
public class PropuestaService implements IPropuestaService{
	
	@Autowired
	IPropuestaDao propuestaDao;
	
	private Paginacion paginacion;

	public Paginacion getPaginacion() {
		return this.paginacion;
	}

	private Error error;

	public Error getError() {
		return this.error;
	}

	@Override
	public List<Propuesta> findAllByEspera(int idPresidente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Propuesta> findAllByEsperaPag(int idPresidente, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}