package com.pucp.aevent.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PARAMETRO")
public class Parametro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_parametro")
	private int idParametro;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=60, message="el tamaño tiene que estar entre 0 y 60")
	@Column(unique = true, length = 60, name="nombre")
	private String nombre;
	
	@Column(name="activo")
	private Boolean activo;
	
	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
	private static final long serialVersionUID = 1L;
}
