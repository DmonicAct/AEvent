package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "PROPUESTA")
@NamedQueries({ @NamedQuery(name = "Propuesta.findAll", query = "SELECT p FROM Propuesta p") })
public class Propuesta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPropuesta")
	private int idPropuesta;
	
	@Column(name = "idEvento")
	private int idEvento;
	
	@Column(name = "idPostulante")
	private int idPostulante;
	
	@Column(name = "fecha_postulacion")
	private Date fecha_postulacion;

	
	@Transient
	private List<Persona> evaluadoresAsignados;
	
	private static final long serialVersionUID = 1L;

	public int getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public Date getFecha_postulacion() {
		return fecha_postulacion;
	}

	public void setFecha_postulacion(Date fecha_postulacion) {
		this.fecha_postulacion = fecha_postulacion;
	}

	public List<Persona> getEvaluadoresAsignados() {
		return evaluadoresAsignados;
	}

	public void setEvaluadoresAsignados(List<Persona> evaluadoresAsignados) {
		this.evaluadoresAsignados = evaluadoresAsignados;
	}

}
