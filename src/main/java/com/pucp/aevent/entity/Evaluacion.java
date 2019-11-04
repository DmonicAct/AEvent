package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVALUACION")
public class Evaluacion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEvaluacion")
	private int idEvaluacion;
	
	@Column(name = "idPropuesta")
	private int idPropuesta;
	
	@Column(name = "idEvaluador")
	private int idEvaluador;
	
	@Column(name = "idFase")
	private int idFase;
	
	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "veredicto")
	private String veredicto;
	
	@Column(name = "evaluado")
	private Boolean evaluado;

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public int getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public int getIdEvaluador() {
		return idEvaluador;
	}

	public void setIdEvaluador(int idEvaluador) {
		this.idEvaluador = idEvaluador;
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getVeredicto() {
		return veredicto;
	}

	public void setVeredicto(String veredicto) {
		this.veredicto = veredicto;
	}

	public Boolean getEvaluado() {
		return evaluado;
	}

	public void setEvaluado(Boolean evaluado) {
		this.evaluado = evaluado;
	}
	
	private static final long serialVersionUID = 1L;
}