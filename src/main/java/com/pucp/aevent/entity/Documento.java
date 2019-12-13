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
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="idPropietario")
	private Integer idPropietario;
	
	@Column(name="idPostulacion")
	private Integer idPostulacion;
	
	@Column(name="documento_disponible")
	private Boolean enabled;

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







	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Integer getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}







	private static final long serialVersionUID = 1L;
}