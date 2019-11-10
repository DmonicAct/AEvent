package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface IPreferenciaService {
	public Preferencia save(Preferencia preferencia);
	public List<Preferencia> findByUsuario(Persona user, Pageable pageable);
	Paginacion getPaginacion();
	Error getError();
//	public List<Preferencia> findByIdUsuario(int idUsuario);
//	public Preferencia findByUsuarioAndPropuesta(Usuario user,Propuesta prop);
}
