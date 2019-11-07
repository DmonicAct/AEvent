package com.pucp.aevent.entity.request_objects;

import java.io.Serializable;
import java.util.List;

import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.RespuestaFormulario;

public class RespuestaFormularioxPostulacionRequest implements Serializable{
	
	private Postulacion postulacion;
	private List<RespuestaFormulario> listaFormulario;
	
	
	public Postulacion getPostulacion() {
		return postulacion;
	}


	public void setPostulacion(Postulacion postulacion) {
		this.postulacion = postulacion;
	}


	public List<RespuestaFormulario> getListaFormulario() {
		return listaFormulario;
	}


	public void setListaFormulario(List<RespuestaFormulario> listaFormulario) {
		this.listaFormulario = listaFormulario;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
