package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.RespuestaFormulario;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

import org.springframework.data.domain.Pageable;

public interface IPostulacionService {
	public Postulacion save(Postulacion postulacion);
	public Postulacion findById(Long idPostulacion, Long idEvento);
	public List<Postulacion> findAll(Long idUsuario,Pageable page);
	public Boolean existsPostulacion(Long idUsuario, Long idEvento);
	public Boolean existsPropuesta(int idUsuario, int idEvento);
	public Propuesta savePropuesta(Propuesta propuesta);
	public List<Propuesta> findAllPropuesta(Usuario idUsuario,Pageable page);
	public Propuesta findByPostulanteAndEvento(Usuario idUsuario,Evento evento);
	public Propuesta findByIdPropuesta(Integer idPropuesta);
	public List<Postulacion> findAllByPropuesta(Long idPropuesta);
	public List<RespuestaFormulario> findAllByPostulacion(Long idPostulacion);
	
	public Postulacion findByIdPostulacion(Long idPostulacion);
	public Postulacion enviarPostulacion(Postulacion postulacion);
	
	Paginacion getPaginacion();
	Error getError();
}
