package com.pucp.aevent.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "pregunta")
public class Pregunta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private Long idPregunta;
    
    @Column(name="indice")
    private Integer indice;
    
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "tipo_pregunta")
    private String tipoPregunta;
    
    @Column(name = "maxCaracteres")
    private Integer maxCaracteres;

    @Column(name = "idSeccion")
    private Long idSeccion;

    public Pregunta() {
    }

    public Pregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getMaxCaracteres() {
		return maxCaracteres;
	}

	public void setMaxCaracteres(Integer maxCaracteres) {
		this.maxCaracteres = maxCaracteres;
	}

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Long getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}
	/*
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
