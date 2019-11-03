package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "RespuestaFase")
public class RespuestaFase implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRespuestaFase")
	private Integer idRespuestaFase;
	
	@ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "idCriterio")
    private Criterio criterio;
	
	@Column(name="descRespuesta")
	private String respuesta;

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public Integer getIdRespuestaFase() {
		return idRespuestaFase;
	}

	public void setIdRespuestaFase(Integer idRespuestaFase) {
		this.idRespuestaFase = idRespuestaFase;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
