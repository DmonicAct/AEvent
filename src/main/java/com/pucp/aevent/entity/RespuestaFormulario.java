package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RespuestaFormulario")
public class RespuestaFormulario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRespuestaFormulario")
	private Long idRespuestaFormulario;
	
	@Column(name="idPostulacion")
	private Long idPostulacion;
	
	@Column(name="idFase")
	private Long idFase;
	
	@Column(name="idEvento")
	private Long idEvento;
	
	@Column(name="idDivision")
	private Long idDivision;
	
	@Column(name="idSeccion")
	private Long idSeccion;
	
	@Column(name="idPregunta")
	private Long idPregunta;
	
	@Column(name="tipoPregunta")
	private String tipoPregunta;
	
	@Column(name="respuesta")
	private String respuesta;
	
	
	public Long getIdRespuestaFormulario() {
		return idRespuestaFormulario;
	}


	public void setIdRespuestaFormulario(Long idRespuestaFormulario) {
		this.idRespuestaFormulario = idRespuestaFormulario;
	}


	public Long getIdFase() {
		return idFase;
	}


	public void setIdFase(Long idFase) {
		this.idFase = idFase;
	}


	public Long getIdEvento() {
		return idEvento;
	}


	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}


	public Long getIdDivision() {
		return idDivision;
	}


	public void setIdDivision(Long idDivision) {
		this.idDivision = idDivision;
	}


	public Long getIdSeccion() {
		return idSeccion;
	}


	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}


	public Long getIdPregunta() {
		return idPregunta;
	}


	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}


	public String getTipoPregunta() {
		return tipoPregunta;
	}


	public void setTipoPregunta(String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}


	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Long getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(Long idPostulacion) {
		this.idPostulacion = idPostulacion;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
