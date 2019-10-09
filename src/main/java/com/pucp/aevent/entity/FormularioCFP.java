package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "formulariocfp")
public class FormularioCFP implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFormularioCFP")
	private int idFormularioCFP;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=100, message="el tamaño tiene que estar entre 6 y 20")
	@Column( length = 100, name="titulo")
	private String titulo;

	@OneToMany(mappedBy = "idFormulario",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Division> divisionList;
	
	
	public int getIdFormularioCFP() {
		return idFormularioCFP;
	}

	public void setIdFormularioCFP(int idFormularioCFP) {
		this.idFormularioCFP = idFormularioCFP;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

	public List<Division> getDivisionList() {
		return divisionList;
	}

	public void setDivisionList(List<Division> divisionList) {
		this.divisionList = divisionList;
	}



	private static final long serialVersionUID = 1L;
}
