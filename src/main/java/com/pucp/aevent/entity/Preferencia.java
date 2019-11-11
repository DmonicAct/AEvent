package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Preferencia")
public class Preferencia implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPreferencia")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPropuesta",referencedColumnName = "idPropuesta")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Propuesta propuesta;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Propuesta getPropuesta() {
		return propuesta;
	}


	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")  
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPropuesta")  
	public Propuesta getPropuesta() {
		return propuesta;
	}
	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}*/
	
	private static final long serialVersionUID = 1L;
}
