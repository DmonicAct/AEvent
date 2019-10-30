package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Evento")
@NamedQueries({ @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e") })
public class Evento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEvento")
	private int idEvento;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fechaInicio")
	private Date fechaInicio;

	@Column(name = "fechaFin")
	private Date fechaFin;

	@Column(name = "capacidad")
	private Integer capacidad;
//
//	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name="id_organizador")
//	private Persona organizador;
//	
//	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name="id_presidente")
//	private Persona presidente;

	@JoinColumn(name = "idPresidente", referencedColumnName = "idUsuario")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario presidente;
	@JoinColumn(name = "idOrganizador", referencedColumnName = "idUsuario")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario organizador;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "persona_comite", joinColumns = @JoinColumn(name = "idEvento", referencedColumnName = "idEvento"), inverseJoinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "idEvento", "idUsuario" }) })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Usuario> comite;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "evento_categoria", joinColumns = @JoinColumn(name = "idEvento", referencedColumnName = "idEvento"), inverseJoinColumns = @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "idEvento", "idCategoria" }) })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Categoria> categorias;

	@JoinColumn(name = "idLugar", referencedColumnName = "idLugar")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Lugar lugar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoEvento")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoEvento tipoEvento;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idFormularioCFP")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private FormularioCFP formulario;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_evento")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Fase> fases = new ArrayList<>();

	@Column(name = "estado")
	private Boolean estado;

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Persona organizador) {
		this.organizador = organizador;
	}

	public List<Usuario> getComite() {
		return comite;
	}

	public void setComite(List<Usuario> comite) {
		this.comite = comite;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public FormularioCFP getFormulario() {
		return formulario;
	}

	public void setFormulario(FormularioCFP formulario) {
		this.formulario = formulario;
	}

	public Usuario getPresidente() {
		return presidente;
	}

	public void setPresidente(Persona presidente) {
		this.presidente = presidente;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

//	public List<Fase> getFases() {
//		return fases;
//	}
//
//
//	public void setFases(List<Fase> fases) {
//		this.fases = fases;
//	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
