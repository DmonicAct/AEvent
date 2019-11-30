package com.pucp.aevent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pucp.aevent.dao.IEvaluacionDao;
import com.pucp.aevent.dao.IEventoDao;
import com.pucp.aevent.dao.IPostulacionDao;
import com.pucp.aevent.dao.IPropuestaDao;
import com.pucp.aevent.dao.IRespuestaFormularioDao;
import com.pucp.aevent.dao.IUsuarioDao;
import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.RespuestaFormulario;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;
import com.pucp.aevent.service.IPostulacionService;
import com.pucp.aevent.util.UtilConstanst;

@Service
public class PostulacionService implements IPostulacionService{
	
	@Autowired
	IPostulacionDao dao;
	
	@Autowired
	IRespuestaFormularioDao daoRespuesta;
	
	@Autowired
	IPropuestaDao daoPropuesta;
	
	@Autowired
	IEventoDao daoEvento;
	
	@Autowired
	IUsuarioDao daoUsuario;
	
	@Autowired
	IEvaluacionDao daoEvaluacion;
	
	private Paginacion paginacion;
	public Paginacion getPaginacion() {
		return this.paginacion;
	}
	
	private Error error;
	public Error getError() {
		return this.error;
	}
	private Logger logger = LoggerFactory.getLogger(PostulacionService.class);
	
	@Override
	public Postulacion save(Postulacion postulacion) {
		Postulacion post = null;
		try {
			if(postulacion.getEstado()==null || postulacion.getEstado().trim()=="") {
				postulacion.setEstado(UtilConstanst.POSTULACION_BORRADOR);
			}
			Propuesta propuesta = this.daoPropuesta.findByIdPropuesta(Integer.valueOf(postulacion.getIdPropuesta().toString()));
			if(propuesta.getFase_actual()==null) {
				propuesta.setFase_actual(propuesta.getEvento().getFases().get(0).getIdFase());
			}
			post = this.dao.save(postulacion);
			
			//VERIFICAR FASE DE POSTULACION PARA GENERAR NUEVAS EVALUACIONES AUTOMATICAMENTE
			Evento e = this.daoEvento.findByIdEvento(postulacion.getIdEvento().intValue());
			List<Fase> fasesEvento = e.getFases();
			Long primeraFase = (fasesEvento.get(0)).getIdFase();
			if(primeraFase!=postulacion.getIdFase()) { //SI ESTA EN LA PRIMERA FASE NO SE HACE NADA, SO SOLO SE VALIDA ....
				//SI ESTA EN UNA FASE POSTERIOR SE GENERAN NUEVAS EVALUACIONES DE LA FASE SIGUIENTE
				List<Persona> evaluadores = propuesta.getEvaluadoresAsignados();
				for(Persona p: evaluadores) {
					//PARA CADA EVALUADOR SE GENERA UNA NUEVA EVALUACION CONTENIENDO A LA SIGUIENTE FASE
					Evaluacion eval = new Evaluacion();
					eval.setEvaluador(p);
					eval.setPropuesta(propuesta);
					Long faseActual = postulacion.getIdFase();
					int position=-1;
					for (int i = 0; i < fasesEvento.size(); i++) {
					    if (fasesEvento.get(i).getIdFase() == faseActual) {
					        position = i;
					        break;
					    }
					}
					eval.setFase(fasesEvento.get(position+1));
					eval.setEstado(UtilConstanst.EVALUACION_ASIGNADA);
					this.daoEvaluacion.save(eval);
				}
			}
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(Save): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(Save): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}

	@Override
	public Postulacion findById(Long idPostulacion, Long idEvento) {
		Postulacion post= null;
		try {
			post = this.dao.findByIdPostulacionAndIdEvento(idPostulacion, idEvento);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}
	
	@Override
	public Postulacion findByIdPostulacion(Long idPostulacion) {
		Postulacion post= null;
		try {
			post = this.dao.findByIdPostulacion(idPostulacion);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(findByIdPostulacion): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByIdPostulacion): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}
	
	@Override
	public List<Postulacion> findAll(Long idUsuario,Pageable page){
		Page<Postulacion> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = dao.findByIdUsuario(idUsuario,page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		
		return lista.getContent();
	}
	
	@Override
	public Boolean existsPostulacion(Long idUsuario, Long idEvento) {
		Boolean post= null;
		try {
			post = this.dao.existsByIdUsuarioAndIdEvento(idUsuario,idEvento);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findById): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}
	
	@Override
	public Propuesta savePropuesta(Propuesta propuesta) {
		Propuesta prop= null;
		try {
			if(propuesta.getIdPropuesta()==null) {
				propuesta.setEstado(UtilConstanst.PROPUESTA_SIN_ASIGNAR);
			}
			prop = this.daoPropuesta.save(propuesta);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(savePropuesta): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(savePropuesta): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return prop;
	}

	@Override
	public Boolean existsPropuesta(int idUsuario, int idEvento) {
		Usuario postulante = this.daoUsuario.findByIdUsuario(idUsuario);
		
		Evento evento = this.daoEvento.findByIdEvento(idEvento);
		Boolean exists = null;
		try {
			exists = this.daoPropuesta.existsByPostulanteAndEvento(postulante, evento);
		} catch (Exception e) {
			logger.error("Error en Postulacion Service(existsPropuesta): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(existsPropuesta): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return exists;
	}

	@Override
	public List<Propuesta> findAllPropuesta(Usuario usuario, Pageable page) {
		Page<Propuesta> lista = null;
		this.paginacion = new Paginacion();
		this.paginacion.setPageable(page);
		try {
			lista = this.daoPropuesta.findByPostulante(usuario,page); 
			this.paginacion.setTotalRegistros(lista.getTotalElements());
			
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findAll): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		
		return lista.getContent();
	}
	@Override
	public Propuesta findByPostulanteAndEvento(Usuario usuario,Evento evento) {
		Propuesta prop= null;
		try {
			prop = this.daoPropuesta.findByPostulanteAndEvento(usuario,evento);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return prop;
	}

	@Override
	public Propuesta findByIdPropuesta(Integer idPropuesta) {
		Propuesta prop= null;
		try {
			prop = this.daoPropuesta.findByIdPropuesta(idPropuesta);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return prop;
	}

	@Override
	public List<Postulacion> findAllByPropuesta(Long idPropuesta) {
		List<Postulacion> lista= null;
		try {
			lista = this.dao.findByIdPropuesta(idPropuesta);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return lista;
	}

	@Override
	public List<RespuestaFormulario> findAllByPostulacion(Long idPostulacion) {
		List<RespuestaFormulario> lista= null;
		try {
			lista = this.daoRespuesta.findByIdPostulacion(idPostulacion);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(findByPostulante): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return lista;
	}

	@Override
	public Postulacion enviarPostulacion(Postulacion postulacion) {
		Postulacion post = null;
		try {
			postulacion.setEstado(UtilConstanst.POSTULACION_EN_ESPERA);
			post = this.dao.save(postulacion);
		}catch(Exception e) {
			logger.error("Error en Postulacion Service(enviarPostulacion): " + e.getMessage());
			this.error.setMensaje("Error en Postulacion Service(enviarPostulacion): " + e.getMessage());
			this.error.setMensajeInterno(e.getCause().toString());
		}
		return post;
	}
}
