package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NUSUARIOID")
	private int idUsuario;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=6, max=20, message="el tamaño tiene que estar entre 6 y 20")
	@Column(unique = true, length = 20, name="VUSERNAME")
	private String username;
	
	@Column(length = 60, name="VPASSWORD")
	@JsonIgnore
	private String password;
	
	@Column(length = 30,name="NUSUARIO_ACTIVO")
	private Boolean enabled;
	
	@NotEmpty(message ="no puede estar vacio")
	@Email(message="no es una dirección de correo bien formada")
	@Column(length = 30,name="VEMAIL")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="USUARIOS_ROLES", joinColumns= @JoinColumn(name="NID_USUARIO"),
	inverseJoinColumns=@JoinColumn(name="NID_ROL"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"NID_USUARIO", "NID_ROL"})})
	private List<Role> roles;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


//	public Persona getPersona() {
//		return persona;
//	}
//
//
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
