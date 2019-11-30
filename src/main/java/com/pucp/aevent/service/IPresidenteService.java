package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.request_objects.PostulacionPropuestaRequest;

public interface IPresidenteService {
	public PostulacionPropuestaRequest obtenerPostulacionesEnEsperaYPropuestas(int idPresidente);
}
