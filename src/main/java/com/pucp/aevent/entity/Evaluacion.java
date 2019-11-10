package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idEvaluador",referencedColumnName = "idUsuario")
	private Usuario evaluador;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idFase")
	private Fase fase;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "idPropuesta")
	private Propuesta propuesta;
	
	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "veredicto")
	private String veredicto;
	
	@Column(name = "evaluado")
	private Boolean evaluado;
	
	@Column(name = "abierto")
	private Boolean abierto;
	
	@Column(name = "sigueEvaluando")
	private Boolean sigueEvaluando;
	
	public Evaluacion() {
	}
	
	public Boolean getSigueEvaluando() {
		return sigueEvaluando;
	}



	public void setSigueEvaluando(Boolean sigueEvaluando) {
		this.sigueEvaluando = sigueEvaluando;
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
	
	public Boolean getAbierto() {
		return abierto;
	}

	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}

	public Propuesta getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}

	private static final long serialVersionUID = 1L;
}