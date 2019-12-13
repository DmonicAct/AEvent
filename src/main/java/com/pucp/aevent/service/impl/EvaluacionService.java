package com.pucp.aevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.dao.IFaseDao;
import com.pucp.aevent.dao.IPostulacionDao;
import com.pucp.aevent.dao.IPreferenciaDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Division;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.FormularioCFP;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IDivisionService;
import com.pucp.aevent.service.IEvaluacionService;
import com.pucp.aevent.util.UtilConstanst;

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
	
	@Autowired
	IDivisionService divisionService;
	
	@Autowired
	IPostulacionDao daoPostulacion;
	
	@Autowired
	IFaseDao daoFase;
	
	
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
		e.setEstado("EVALUACION_ASIGNADA");
		e.setEvaluador(evaluador);
		e.setFase(fase);
		e.setPropuesta(propuesta);
		//e.setOpinion("");
		//e.setVeredicto("");
		//e.setSigueEvaluando(true);
		e = daoEvaluacion.save(e);
		
		//CAMBIAR ESTADO DE PROPUESTA A ASIGNADA
		Propuesta p = this.daoPropuesta.findByIdPropuesta(propuesta.getIdPropuesta());
		p.setEstado(UtilConstanst.PROPUESTA_ASIGNADA);
		this.daoPropuesta.save(p);
		
		Usuario u = daoUsuario.findByIdUsuario(evaluador.getIdUsuario());
		u.setEvaluacionSinLeer(true);
		daoUsuario.save(u);
				
		return e;
	}
	
	public void save(Evaluacion evaluacion) {
		evaluacion.setEstado(UtilConstanst.EVALUACION_CORREGIDA);
		daoEvaluacion.save(evaluacion);
		
		Propuesta prop = evaluacion.getPropuesta();
		prop = this.daoPropuesta.findByIdPropuesta(prop.getIdPropuesta());
		List<Evaluacion> lstEval = this.daoEvaluacion.findAllByPropuestaAndEstado(prop, UtilConstanst.EVALUACION_ASIGNADA);
		//Si esta vacio significa que ya todas las evaluaciones fueron evaluadas
		//Por lo que, se debe de cambiar el estado a "EN_ESPERA" para que el presidente lo califique
		if (lstEval.isEmpty() || lstEval.size()==0) {
			Long faseActual = prop.getFase_actual();
			Postulacion postulacion = this.daoPostulacion.findByIdPropuestaAndIdFase(prop.getIdPropuesta().longValue(), faseActual);
			postulacion.setEstado(UtilConstanst.POSTULACION_EN_ESPERA);
			this.daoPostulacion.save(postulacion);
		}			
	}
	
	public void desasignar(int id) {
		Evaluacion evaluacion = daoEvaluacion.findByIdEvaluacion(id);
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

	@Override
	public Evaluacion findByIdEvaluacion(int idEvaluacion) {
		Evaluacion eva = null;
		try {
			eva = this.daoEvaluacion.findByIdEvaluacion(idEvaluacion);
			Fase fase = eva.getFase();
			if(fase!=null && (fase.getFormulario()!=null && fase.getFormulario().getIdFormulariocfp()!=null)) {
				FormularioCFP formulario = fase.getFormulario();
				List<Division> listaDivision = this.divisionService.findByIdFormulario(formulario.getIdFormulariocfp());
				formulario.setDivisionList(listaDivision);
				fase.setFormulario(formulario);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return eva;
	}

	@Override
	public List<Evaluacion> findAllByPropuesta(Propuesta propuesta) {
		List<Evaluacion> lista = null;
		try {
			lista = this.daoEvaluacion.findByPropuesta(propuesta);
			for(Evaluacion eva: lista){
				Fase fase = eva.getFase();
				if(fase!=null && (fase.getFormulario()!=null && fase.getFormulario().getIdFormulariocfp()!=null)) {
					FormularioCFP formulario = fase.getFormulario();
					List<Division> listaDivision = this.divisionService.findByIdFormulario(formulario.getIdFormulariocfp());
					formulario.setDivisionList(listaDivision);
					fase.setFormulario(formulario);
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return lista;
	}
}