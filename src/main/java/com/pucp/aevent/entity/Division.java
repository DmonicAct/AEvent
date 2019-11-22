package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "division")
public class Division implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_division")
    private Long idDivision;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name="indice")
    private Integer indice;
    
    @Column(name="idFormulariocfp")
    private Long idFormulariocfp;
    
    @Transient
    private List<Seccion> seccionList;

    public Division() {
    }
    
    public Division(Long idDivision) {
        this.idDivision = idDivision;
    }
    
    public Long getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Long idDivision) {
        this.idDivision = idDivision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Seccion> getSeccionList() {
        return seccionList;
    }

	public void setSeccionList(List<Seccion> seccionList) {
        this.seccionList = seccionList;
    }

    public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}


	public Long getIdFormulariocfp() {
		return idFormulariocfp;
	}

	public void setIdFormulariocfp(Long idFormulariocfp) {
		this.idFormulariocfp = idFormulariocfp;
	}


	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
    private static final long serialVersionUID = 1L;
}
