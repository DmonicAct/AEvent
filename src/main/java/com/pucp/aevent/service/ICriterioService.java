package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Criterio;
import com.pucp.aevent.entity.response_objects.Error;

public interface ICriterioService {
	Error getError();
	public List<Criterio> findAll();
	
	public void save(Criterio criterio);
	
	public List<Criterio> findByFase(Fase fase);
}
