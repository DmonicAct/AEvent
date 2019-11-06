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
	@Column(unique = false, length = 60, name="descripcion_corta")
	private String descripcionCorta;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=60, message="el tamaño tiene que estar entre 0 y 60")
	@Column(unique = false, length = 60, name="descripcion")
	private String descripcion;
	
	@Column(name="activo")
	private Boolean enabled;
	
	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}




	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}




	private static final long serialVersionUID = 1L;
}
