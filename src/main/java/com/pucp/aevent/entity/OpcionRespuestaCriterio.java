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
@Table(name = "OpcionRespuestaCriterio")
public class OpcionRespuestaCriterio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idOpcionRespuestaCriterio")
	private Integer idOpcionRespuestaCriterio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "idCriterio", nullable = false, updatable = false)
    private Criterio criterio;
	
	/*
	@Column(name="ordenOpcion")
	private Integer ordenOpcion;
	*/
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public Integer getOrdenOpcion() {
		return ordenOpcion;
	}

	public void setOrdenOpcion(Integer ordenOpcion) {
		this.ordenOpcion = ordenOpcion;
	}
	*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
