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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.pucp.aevent.entity.Pregunta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pregunta")
public class Pregunta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pregunta")
	private int idPregunta;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=50, message="el tamaño tiene que estar entre 0 y 20")
	@Column(length = 50, name="descripcion")
	private String descripcion;
	
	@Column(name="tipo_pregunta")
	private String tipoPregunta;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_division")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Division division;
	
	
	public int getIdPregunta() {
		return idPregunta;
	}



	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getTipoPregunta() {
		return tipoPregunta;
	}



	public void setTipoPregunta(String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	/*
	 * 
	 * 
	 * */

	private static final long serialVersionUID = 1L;
}
