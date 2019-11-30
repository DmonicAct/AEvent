package com.pucp.aevent.service;

import com.pucp.aevent.entity.request_objects.PostulacionPropuestaRequest;

public interface IPresidenteService {
	public PostulacionPropuestaRequest obtenerPostulacionesEnEsperaYPropuestas(int idPresidente);
	public void DesaprobarPostulacion(Long idPostulacion);
	public void AprobarPostulacion(Long idPostulacion);
}
