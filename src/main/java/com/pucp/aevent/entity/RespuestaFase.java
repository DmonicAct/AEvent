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
    @JoinColumn(name = "idFase", nullable = false, updatable = false)
    private Fase fase;
	
	@ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "idCriterio", nullable = false, updatable = false)
    private Criterio criterio;
	
	@ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "idOpcionRespuestaCriterio", nullable = false, updatable = false)
    private OpcionRespuestaCriterio opcionRespuesta;
				
	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public OpcionRespuestaCriterio getOpcionRespuesta() {
		return opcionRespuesta;
	}

	public void setOpcionRespuesta(OpcionRespuestaCriterio opcionRespuesta) {
		this.opcionRespuesta = opcionRespuesta;
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
