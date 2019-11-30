package com.pucp.aevent.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPostulacionDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.request_objects.PostulacionPropuestaRequest;
import com.pucp.aevent.service.IPresidenteService;
import com.pucp.aevent.service.IUsuarioService;
import com.pucp.aevent.util.UtilConstanst;

@Service
public class PresidenteService implements IPresidenteService {

	@Autowired
	IPostulacionDao postulacionDao;
	
	@Autowired
	IPropuestaDao propuestaDao;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IEventoDao eventoDao;

	@Override
	public PostulacionPropuestaRequest obtenerPostulacionesEnEsperaYPropuestas(int idPresidente) {
		List<Postulacion> listaPostulacion = null;
		List<Propuesta> listaPropuesta = null;
		List<Integer> listaIds = new ArrayList<>();
		List<Long> listIdsEvento = new ArrayList<>();
		PostulacionPropuestaRequest pp = new PostulacionPropuestaRequest();
		try {
			Usuario presidente = this.usuarioService.findById(idPresidente);
			List<Evento> lista_evento = this.eventoDao.findByPresidente(presidente);
			for(Evento e: lista_evento) {
				listIdsEvento.add(Long.valueOf(e.getIdEvento()));
			}
			listaPostulacion = this.postulacionDao.findByEstadoAndIdEventoIn(UtilConstanst.POSTULACION_EN_ESPERA, listIdsEvento);
			for(Postulacion p: listaPostulacion) {
				listaIds.add(p.getIdPropuesta().intValue());
			}
			listaPropuesta = this.propuestaDao.findByIdPropuestaIn(listaIds);
			//
			pp.setPostulacion(listaPostulacion);
			pp.setPropuesta(listaPropuesta);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return pp;
	}
	
	

}
