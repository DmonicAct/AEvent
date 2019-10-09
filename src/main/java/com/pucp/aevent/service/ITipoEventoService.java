package com.pucp.aevent.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pucp.aevent.entity.TipoEvento;
import com.pucp.aevent.entity.response_objects.Error;
import com.pucp.aevent.entity.response_objects.Paginacion;

public interface ITipoEventoService {
	public List<TipoEvento> findAll(Pageable pageable);
	public List<TipoEvento> findAll();
	public TipoEvento findByIdTipoEvento(Integer id);
	Paginacion getPaginacion();
	Error getError();
	public TipoEvento guardarTipoEvento(TipoEvento tipoEvento);
	public void delete(TipoEvento tipoEvento);
}
