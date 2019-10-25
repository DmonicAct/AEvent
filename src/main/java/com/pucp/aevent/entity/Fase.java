package com.pucp.aevent.entity;

import com.pucp.aevent.entity.Evento;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Fase")
public class Fase implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFase")
	private Integer idFase;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechaInicial")
	private Date fechaInicial;
	
	@Column(name="fechaFin")
	private Date fechaFin;
	
	@ManyToOne
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "idEvento", nullable = false, updatable = false)
    private Evento evento;
	
	public Integer getIdFase() {
		return idFase;
	}


	public void setIdFase(Integer idFase) {
		this.idFase = idFase;
	}


	

	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
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





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
