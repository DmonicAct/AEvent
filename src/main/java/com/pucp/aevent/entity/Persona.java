package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAS")
public class Persona extends Usuario implements Serializable{
	
	@Column(length = 30, name="VNOMBRE")
	private String nombre;
	@Column(length = 30, name="VAPELLIDOPAT")
	private String appaterno;
	@Column(length = 30, name="VAPELLIDOMAT")
	private String apmaterno;
	@Column(unique=true,length = 10, name="VDNI")
	private String dni;

	public String getNombre() {
		return nombre;
	}	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAppaterno() {
		return appaterno;
	}
	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}
	public String getApmaterno() {
		return apmaterno;
	}
	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

