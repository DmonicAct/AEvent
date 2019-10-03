package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Fase")
public class Fase implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFase")
	private Integer id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechaInicial")
	private Date fechaInicial;
	
	@Column(name="fechaFin")
	private Date fechaFin;
	
	@OneToMany
	private List<Criterio> criterios;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaInicial() {
		return fechaInicial;
	}


	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public List<Criterio> getCriterios() {
		return criterios;
	}


	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
