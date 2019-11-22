package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "formulariocfp")
public class FormularioCFP implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_formulariocfp")
	private Long idFormulariocfp;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=100, message="el tama�o tiene que estar entre 6 y 20")
	@Column( length = 100, name="titulo")
	private String titulo;
	
	@Transient
	private List<Division> divisionList;
	
	public FormularioCFP() {
    }

    public FormularioCFP(Long idFormulariocfp) {
        this.idFormulariocfp = idFormulariocfp;
    }
    
	public Long getIdFormulariocfp() {
		return idFormulariocfp;
	}

	public void setIdFormulariocfp(Long idFormulariocfp) {
		this.idFormulariocfp = idFormulariocfp;
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
	/*
	 * 
	 * 
	 * 
	 * 
	 * */
	private static final long serialVersionUID = 1L;
}
