package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Criterio")
public class Criterio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCriterio")
	private Integer idCriterio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoCriterio", referencedColumnName = "idTipoCriterio")
	private TipoCriterio tipoCriterio;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="id_fase")
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //private Fase fase;
	
	@ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "id_fase")
    private Fase fase;

	public TipoCriterio getTipoCriterio() {
		return tipoCriterio;
	}


	public void setTipoCriterio(TipoCriterio tipoCriterio) {
		this.tipoCriterio = tipoCriterio;
	}


	public Integer getIdCriterio() {
		return idCriterio;
	}


	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
