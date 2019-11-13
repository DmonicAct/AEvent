package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "PROPUESTA")
@NamedQueries({ @NamedQuery(name = "Propuesta.findAll", query = "SELECT p FROM Propuesta p") })
public class Propuesta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPropuesta")
	private int idPropuesta;
	
	@OneToOne
	@JoinColumn(name = "idEvento",referencedColumnName = "idEvento")
	private Evento evento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPostulante",referencedColumnName = "idUsuario")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario postulante;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_postulacion")
	private Date fecha_postulacion= new Date();;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "cantidad_sesiones")
	private Long cantidad_sesiones;
	
	@Column(name = "publico_dirigido")
	private String publico_dirigido;
	
	@Column(name = "conocimiento")
	private String conocimiento_previo;
	
	@Transient
	private List<Persona> evaluadoresAsignados;
		
	private static final long serialVersionUID = 1L;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Persona> getEvaluadoresAsignados() {
		return evaluadoresAsignados;
	}

	public void setEvaluadoresAsignados(List<Persona> evaluadoresAsignados) {
		this.evaluadoresAsignados = evaluadoresAsignados;
	}

	public Usuario getPostulante() {
		return this.postulante;
	}

	public void setPostulante(Usuario postulante) {
		this.postulante = postulante;
	}

	public int getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public Evento getIdEvento() {
		return evento;
	}

	public void setIdEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getFecha_postulacion() {
		return fecha_postulacion;
	}

	public void setFecha_postulacion(Date fecha_postulacion) {
		this.fecha_postulacion = fecha_postulacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCantidad_sesiones() {
		return cantidad_sesiones;
	}

	public void setCantidad_sesiones(Long cantidad_sesiones) {
		this.cantidad_sesiones = cantidad_sesiones;
	}

	public String getPublico_dirigido() {
		return publico_dirigido;
	}

	public void setPublico_dirigido(String publico_dirigido) {
		this.publico_dirigido = publico_dirigido;
	}

	public String getConocimiento_previo() {
		return conocimiento_previo;
	}

	public void setConocimiento_previo(String conocimiento_previo) {
		this.conocimiento_previo = conocimiento_previo;
	}

	
}
