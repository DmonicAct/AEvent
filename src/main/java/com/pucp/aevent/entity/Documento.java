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
	
	private static final long serialVersionUID = 1L;
}