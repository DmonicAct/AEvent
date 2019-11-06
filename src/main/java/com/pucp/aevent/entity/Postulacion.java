package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Postulacion")
public class Postulacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	private Long fase_actual;
	
	private Date fecha_fin;
	
	private boolean enabled;

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

	public Long getFase_actual() {
		return fase_actual;
	}

	public void setFase_actual(Long fase_actual) {
		this.fase_actual = fase_actual;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
