package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NROLID")
	private Long idRol;
	
	@Column(unique=true, length=20,name="VDESCRIPCION")
	private String nombre;
	
	@Column(name="NROL_ACTIVO")
	private Boolean enabled;
	
	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Long getId() {
		return idRol;
	}


	public void setId(Long idRol) {
		this.idRol = idRol;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
