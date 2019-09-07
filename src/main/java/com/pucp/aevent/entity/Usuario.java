package com.pucp.aevent.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "USUARIOS")
public class Usuario extends Persona implements Serializable {

	@Column(unique = true, length = 20, name="VUSERNAME")
	private String username;

	@Column(length = 60, name="VPASSWORD")
	private String password;
	
	@Column(length = 30,name="NUSUARIO_ACTIVO")
	private Boolean enabled;
	
	@Column(length = 30,name="VEMAIL")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="USUARIOS_ROLES", joinColumns= @JoinColumn(name="NID_USUARIO"),
	inverseJoinColumns=@JoinColumn(name="NID_ROL"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"NID_USUARIO", "NID_ROL"})})
	private List<Role> roles;


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


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
