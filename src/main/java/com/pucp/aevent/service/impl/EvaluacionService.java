package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IEvaluacionService;

@Service
public class EvaluacionService implements IEvaluacionService{
	@Autowired 
	IEvaluacionDao daoEvaluacion;
	
	@Autowired 
	IPropuestaDao daoPropuesta;
	
	@Autowired
	IPreferenciaDao daoPreferencia;
	
	@Autowired
	IUsuarioDao daoUsuario;
	
	private Paginacion paginacion;

	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	public Evaluacion asignarPropuesta(Persona evaluador,Propuesta propuesta,Fase fase) {
		Evaluacion e = new Evaluacion();
		//e.setEvaluado(false);
		//e.setAbierto(true);
		e.setComentarioParticipante("");
		e.setComentarioPresidente("");
		e.setEstado("ASIGNADO");
		e.setEvaluador(evaluador);
		e.setFase(fase);
		e.setPropuesta(propuesta);
		//e.setOpinion("");
		//e.setVeredicto("");
		//e.setSigueEvaluando(true);
		e = daoEvaluacion.save(e);
		
		Preferencia p = new Preferencia();
		p.setPropuesta(propuesta);
		p.setUsuario(evaluador);
		p.setDescripcion("Pendiente confirmaci�n");
		daoPreferencia.save(p);
		
		Usuario u = daoUsuario.findByIdUsuario(evaluador.getIdUsuario());
		u.setEvaluacionSinLeer(true);
		daoUsuario.save(u);
				
		return e;
	}
	
	public void save(Evaluacion evaluacion) {
		daoEvaluacion.save(evaluacion);
	}
	
	public void delete(Evaluacion evaluacion) {
		daoEvaluacion.delete(evaluacion);
	}
	
	public List<Evaluacion> findAllByEvaluador(Persona evaluador, Pageable page){
		Page<Evaluacion> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.daoEvaluacion.findByEvaluador(evaluador, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			for(Evaluacion e : lista.getContent()) {
				e.setPropuesta(this.daoPropuesta.findByIdPropuesta(e.getPropuesta().getIdPropuesta()));
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
}