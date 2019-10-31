package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name="id_formulariocfp")
	private Long idFormulariocfp;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=100, message="el tamaño tiene que estar entre 6 y 20")
	@Column( length = 100, name="titulo")
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name= "id_formulariocfp")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Division> divisionList = new ArrayList<>();
	
	public FormularioCFP() {
    }

    public FormularioCFP(Long idFormulariocfp) {
        this.idFormulariocfp = idFormulariocfp;
    }
    
    public void addDivision(Division division) {
        if (division != null) {
           if (divisionList == null) {
        	   divisionList = new ArrayList<Division>();          
           }
           divisionList.add(division);
           division.setIdFormulario(this);
        }
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

	private static final long serialVersionUID = 1L;
}
