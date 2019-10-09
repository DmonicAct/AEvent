package com.pucp.aevent.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Evento")
public class Evento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEvento")
	private int idEvento;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechaInicio")
	private Date fechaInicio;
	
	@Column(name="fechaFin")
	private Date fechaFin;

	@Column(name="capacidad")
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
    @ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario presidente;
    @JoinColumn(name = "idOrganizador", referencedColumnName = "idUsuario")
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario organizador;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="persona_comite", joinColumns=
	@JoinColumn(name="idEvento", referencedColumnName = "idEvento"),inverseJoinColumns=
	@JoinColumn(name="idUsuario", referencedColumnName = "idUsuario"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"idEvento", "idUsuario"})})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Usuario> comite;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="evento_categoria", joinColumns= 
	@JoinColumn(name="idEvento", referencedColumnName = "idEvento"), inverseJoinColumns=
	@JoinColumn(name="idCategoria", referencedColumnName = "idCategoria"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"idEvento", "idCategoria"})})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Categoria> categorias;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idLugar")
	private Lugar lugar;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idTipoEvento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoEvento tipoEvento;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idFormularioCFP")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private FormularioCFP formulario;
	
	@Column(name="estado")
	private String estado;
	
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



	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
