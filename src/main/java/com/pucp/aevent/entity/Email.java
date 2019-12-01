package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "email")
public class Email implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmail")
    private Integer idEmail;
	
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    
    @Size(max = 50)
    @Column(name="pass")
    private String pass;
    
    public Email() {}

	public Integer getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Integer idEmail) {
		this.idEmail = idEmail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
    
}