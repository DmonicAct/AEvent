package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;

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
}
