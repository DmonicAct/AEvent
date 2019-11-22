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
@Table(name = "seccion")
public class Seccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seccion")
    private Long idSeccion;
    
    @Column(name = "cantidad_preguntas")
    private Integer cantidadPreguntas;
    
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "indice")
    private Integer indice;
    
    @Size(max = 255)
    @Column(name = "tipo_seccion")
    private String tipoSeccion;
    
    @Column(name = "idDivision")
    private Long idDivision;
    
    @Transient
    private List<Pregunta> preguntaList;
        
    public Seccion() {
    }

    public Seccion(Long idSeccion) {
        this.idSeccion = idSeccion;
    }
    
	public Long getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Long idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public void setCantidadPreguntas(Integer cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getTipoSeccion() {
        return tipoSeccion;
    }

    public void setTipoSeccion(String tipoSeccion) {
        this.tipoSeccion = tipoSeccion;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

	public Long getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(Long idDivision) {
		this.idDivision = idDivision;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * */
	private static final long serialVersionUID = 1L;
}

