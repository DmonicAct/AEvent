package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
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
	public List<Propuesta> findAllByEspera() {
		List<Propuesta> lista =null;
		try {
			lista = propuestaDao.findByEstado(UtilConstanst.PROPUESTA_ESPERA);
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		return lista;
	}

	@Override
	public List<Propuesta> findAllByEsperaPag(Pageable page) {
		Page<Propuesta> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.propuestaDao.findByEstado(UtilConstanst.PROPUESTA_ESPERA, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return lista.getContent();
	}	
}