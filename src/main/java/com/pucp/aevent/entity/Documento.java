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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DOCUMENTO")
public class Documento implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDocumento")
	private int idDocumento;
	
	@Column(length=30, name="nombredoc")
	private String nombredoc;
	
	@Column(length=5, name="extensiondoc")
	private String extensiondoc;
	
	@Column(name="contenido")
	private byte[] contenido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPropuesta")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Propuesta propuesta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idFase")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Fase fase;
	
	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNombredoc() {
		return nombredoc;
	}



	public void setNombredoc(String nombredoc) {
		this.nombredoc = nombredoc;
	}



	public String getExtensiondoc() {
		return extensiondoc;
	}



	public void setExtensiondoc(String extensiondoc) {
		this.extensiondoc = extensiondoc;
	}



	public byte[] getContenido() {
		return contenido;
	}



	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}



	public Propuesta getPropuesta() {
		return propuesta;
	}



	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}



	private static final long serialVersionUID = 1L;
}