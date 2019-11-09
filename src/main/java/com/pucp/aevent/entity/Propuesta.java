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
	private Long idPropuesta;
	
	@Column(name = "idEvento")
	private Long idEvento;
	
	@Column(name = "idPostulante")
	private Long idPostulante;
	
	@Column(name = "fecha_postulacion")
	private Date fecha_postulacion;
	
	@Transient
	private List<Persona> evaluadoresAsignados;
	
	private static final long serialVersionUID = 1L;

	public Long getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(Long idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(Long idPostulante) {
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
