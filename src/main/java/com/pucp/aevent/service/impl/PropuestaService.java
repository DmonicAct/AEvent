package com.pucp.aevent.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPropuestaService;
import com.pucp.aevent.service.IUsuarioService;
import com.pucp.aevent.util.UtilConstanst;

@Service
public class PropuestaService implements IPropuestaService{
	
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IEventoDao eventoDao;
	
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
		List<Propuesta> lista =null;
		try {
			lista = propuestaDao.findByEstado(UtilConstanst.PROPUESTA_ESPERA);
			for(Propuesta p : lista) {
				if (p.getEvento().getPresidente().getIdUsuario() != idPresidente)
					lista.remove(p);
			}	
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
		}
		return lista;
	}

	@Override
	public List<Propuesta> findAllByEsperaPag(int idPresidente, Pageable page) {
		Page<Propuesta> lista = null;
		
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			//Obtencion del objeto usuario del presidente
			Usuario presidente = this.usuarioService.findById(idPresidente);
			//Busqueda de eventos del presidente
			List<Evento> lista_evento = this.eventoDao.findByPresidente(presidente);
			HashSet<Integer> ids = new HashSet<Integer>();
			for(Evento eve: lista_evento) {
				ids.add(eve.getIdEvento());
			}
			// Se envia la lista con todos los evento del presidente y se hace match con las propuestas de estos mismos eventos
			lista = this.propuestaDao.findByEstadoAndEventoIn(UtilConstanst.PROPUESTA_ESPERA, lista_evento, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
}