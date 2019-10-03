package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Evento")
public class Evento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEvento")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechaInicio")
	private Date fechaInicio;
	
	@Column(name="fechaFin")
	private Date fechaFin;

	@Column(name="capacidad")
	private Integer capacidad;

	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Persona evaluador;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="PERSONA_COMITE", joinColumns= @JoinColumn(name="idUsuario"),
	inverseJoinColumns=@JoinColumn(name="idEvento"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"idUsuario", "idEvento"})})
	private List<Persona> comite;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idCategoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Categoria> categorias;
	
	@Column(name="tipoEvento")
	private String tipoEvento;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idFormularioCFP")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private FormularioCFP formulario;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	

	public Integer getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}


	public Persona getEvaluador() {
		return evaluador;
	}


	public void setEvaluador(Persona evaluador) {
		this.evaluador = evaluador;
	}


	public List<Persona> getComite() {
		return comite;
	}


	public void setComite(List<Persona> comite) {
		this.comite = comite;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public FormularioCFP getFormulario() {
		return formulario;
	}


	public void setFormulario(FormularioCFP formulario) {
		this.formulario = formulario;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
