package com.pucp.aevent.entity.request_objects;

import java.io.Serializable;
import java.util.List;

import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;

public class PostulacionPropuestaRequest implements Serializable{

	List<Postulacion> postulacion;
	List<Propuesta> propuesta;


	public List<Postulacion> getPostulacion() {
		return postulacion;
	}




	public void setPostulacion(List<Postulacion> postulacion) {
		this.postulacion = postulacion;
	}




	public List<Propuesta> getPropuesta() {
		return propuesta;
	}




	public void setPropuesta(List<Propuesta> propuesta) {
		this.propuesta = propuesta;
	}




	private static final long serialVersionUID = 1L;
}
