package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PROPUESTA")
public class Propuesta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPropuesta")
	private int idPropuesta;
	
	@Column(name = "id_evento")
	private int id_evento;
	
	@Column(name = "id_postulante")
	private int id_postulante;
	
	@Column(name = "fecha_postulacion")
	private Date fecha_postulacion;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="idDocumento")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private List<Documento> documentos = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;

}
