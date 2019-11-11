package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona extends Usuario implements Serializable{
	
	@Column(length = 30, name="nombre")
	private String nombre;
	@Column(length = 30, name="apellidoPat")
	private String appaterno;
	@Column(length = 30, name="apellidoMat")
	private String apmaterno;
	@Column(unique=true,length = 10, name="dni")
	private String dni;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="edad")
	private Integer edad;
	
	@Column(name="fechaNacimiento")
	private Date fechaNacimiento;
    
	public Persona() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAppaterno() {
		return appaterno;
	}
	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}
	public String getApmaterno() {
		return apmaterno;
	}
	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getEddad() {
		return edad;
	}
	public void setEddad(Integer eddad) {
		this.edad = eddad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

