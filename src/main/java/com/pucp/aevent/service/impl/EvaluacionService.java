package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IEvaluacionService;

@Service
public class EvaluacionService implements IEvaluacionService{
	@Autowired IEvaluacionDao dao;
	
	@Autowired IPropuestaDao daoPropuesta;
	
	private Paginacion paginacion;

	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	public Evaluacion save(Integer idEvaluador,Integer idPropuesta,Integer idFase) {
		Evaluacion e = dao.findByIdEvaluadorAndIdPropuestaAndIdFase(idEvaluador,idPropuesta,idFase);
		if (e == null) {
			e = new Evaluacion();
			e.setEvaluado(false);
			e.setIdEvaluador(idEvaluador);
			e.setIdFase(idFase);
			e.setIdPropuesta(idPropuesta);
			e.setOpinion("");
			e.setVeredicto("");
			e = dao.save(e);
			return e;
		}
		return null;
	}
	
	public Integer delete(Integer idEvaluacion) {
		Integer e = dao.deleteByIdEvaluacion(idEvaluacion);
		return e;
		//if (e == null) {
		//	return 0;
		//}
		//return 1;
	}
	
	public List<Evaluacion> listarEvaluacionesDeEvaluador(Integer idEvaluador, Pageable page){
		Page<Evaluacion> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.dao.findByIdEvaluador(idEvaluador, page);
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			for(Evaluacion e : lista.getContent()) {
				e.setPropuesta(this.daoPropuesta.findByIdPropuesta(e.getIdPropuesta()));
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista.getContent();
	}
}