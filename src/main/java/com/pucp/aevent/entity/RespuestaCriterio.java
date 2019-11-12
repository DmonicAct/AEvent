package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "RespuestaCriterio")
public class RespuestaCriterio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRespuestaCriterio")
	private Integer idRespuestaCriterio;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "idCriterio")
    private Integer idCriterio;
	
	@Column(name="descRespuesta")
	private String respuesta;

	public Integer getIdRespuestaCriterio() {
		return idRespuestaCriterio;
	}

	public void setIdRespuestaCriterio(Integer idRespuestaCriterio) {
		this.idRespuestaCriterio = idRespuestaCriterio;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public Integer getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
