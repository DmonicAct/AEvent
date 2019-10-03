package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Division")
public class Division implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDivision")
	private Integer idDivision;
	
	@Column(name="descripcion")	
	private String descripcion;
	
//	@ManyToOne
//    @JoinColumn(name = "id_formulario", nullable = false, updatable = false)
//	private FormularioCFP formularioCFP;
//	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_formulario")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private FormularioCFP formularioCFP;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
	private List<Pregunta> preguntas;
	
	
	public Integer getIdDivision() {
		return idDivision;
	}


	public void setIdDivision(Integer idDivision) {
		this.idDivision = idDivision;
	}

	
	
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Pregunta> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	



	public FormularioCFP getFormularioCFP() {
		return formularioCFP;
	}


	public void setFormularioCFP(FormularioCFP formularioCFP) {
		this.formularioCFP = formularioCFP;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
