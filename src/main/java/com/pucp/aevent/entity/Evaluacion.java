package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EVALUACION")
public class Evaluacion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEvaluacion")
	private int idEvaluacion;
	
	@ManyToOne
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idEvaluador",referencedColumnName = "idUsuario")
	private Usuario evaluador;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idFase")
	private Fase fase;
	
	@ManyToOne
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idPropuesta")
	private Propuesta propuesta;
	
	@Column(name="comentarioParticipante")
	private String comentarioParticipante;
	
	@Column(name="comentarioPresidente")
	private String comentarioPresidente;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="evaluacionGeneral")
	private String evaluacionGeneral;
	
	@Column(name="nivelConfianza")
	private String nivelConfianza;

	
	public String getEvaluacionGeneral() {
		return evaluacionGeneral;
	}





	public void setEvaluacionGeneral(String evaluacionGeneral) {
		this.evaluacionGeneral = evaluacionGeneral;
	}





	public String getNivelConfianza() {
		return nivelConfianza;
	}





	public void setNivelConfianza(String nivelConfianza) {
		this.nivelConfianza = nivelConfianza;
	}





	public String getComentarioParticipante() {
		return comentarioParticipante;
	}





	public void setComentarioParticipante(String comentarioParticipante) {
		this.comentarioParticipante = comentarioParticipante;
	}





	public String getComentarioPresidente() {
		return comentarioPresidente;
	}





	public void setComentarioPresidente(String comentarioPresidente) {
		this.comentarioPresidente = comentarioPresidente;
	}





	public String getEstado() {
		return estado;
	}





	public void setEstado(String estado) {
		this.estado = estado;
	}





	public Evaluacion() {
	}
	




	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Usuario getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(Usuario evaluador) {
		this.evaluador = evaluador;
	}

	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}


	public Propuesta getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}

	private static final long serialVersionUID = 1L;
}