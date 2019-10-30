package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.response_objects.Error;

public interface IFaseService {
	Error getError();
	public List<Fase> findAll();
	
	public void save(Fase fase);
	
	public List<Fase> findByEvento(Evento evento);
	
	public void delete(Fase fase);
}
