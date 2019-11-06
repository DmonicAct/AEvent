package com.pucp.aevent.entity;

import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "ErrorLog")
public class ErrorLog implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idError")
	private int idError;
	
	@Column(name="mensaje")
	private String mensaje;
	
	@Column(name="fechaRegistro")
	private Date fechaRegistro;

	public int getIdError() {
		return idError;
	}

	public void setIdError(int idError) {
		this.idError = idError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public ErrorLog(String mensaje) {
		super();
		this.mensaje = mensaje;
		this.fechaRegistro = new Date();
	}
	
	
}
