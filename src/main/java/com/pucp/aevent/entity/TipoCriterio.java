package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoCriterio")
public class TipoCriterio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTipoCriterio")
	private Integer idTipoCriterio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Integer getIdTipoCriterio() {
		return idTipoCriterio;
	}

	public void setIdTipoCriterio(Integer idTipoCriterio) {
		this.idTipoCriterio = idTipoCriterio;
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
