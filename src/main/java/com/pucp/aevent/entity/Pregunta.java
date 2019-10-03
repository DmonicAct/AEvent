package com.pucp.aevent.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.pucp.aevent.entity.Pregunta;
import com.pucp.aevent.entity.Parametro;

@Entity
@Table(name = "PREGUNTA")
public class Pregunta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDpregunta")
	private int idPregunta;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=0, max=50, message="el tamaño tiene que estar entre 0 y 20")
	@Column(length = 50, name="NOMBRE")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IDPARAMETRO", nullable = false)
	private Parametro tipoPreg;

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Parametro getTipoPreg() {
		return tipoPreg;
	}

	public void setTipoPreg(Parametro tipoPreg) {
		this.tipoPreg = tipoPreg;
	}
	
	private static final long serialVersionUID = 1L;
}
