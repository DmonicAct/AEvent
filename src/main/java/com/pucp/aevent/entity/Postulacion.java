package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Postulacion")
public class Postulacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPostulacion")
	private Long idPostulacion;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(unique = true, length = 60, name="idUsuario")
	private Long idUsuario;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(unique = true, length = 60, name="idEvento")
	private Long idEvento;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(unique = true, length = 60, name="idPropuesta")
	private Long idPropuesta;
	
	@Column(name="idFase")
	private Long idFase;
	
	@Column(name="estado_postulacion")
	private String estado;
	
	@Column(name="estado")
	private Boolean enabled;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "myDate", insertable=false)
	private Date fechaActualizacion;
	
	public Long getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(Long idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdFase() {
		return idFase;
	}

	public void setIdFase(Long idFase) {
		this.idFase = idFase;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
