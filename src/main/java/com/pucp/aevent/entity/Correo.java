package com.pucp.aevent.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Correo")
public class Correo implements Serializable{
	
	//Esta clase solo va a gardar un registro y contendrá
	// el password de la dirección de correo usada
	// y la contraseña usada en la verificación en 2 pasos
	// para el envio de correos del sistema AEVENT
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCorreo")
	private int idCorreo;
	
	@Column(name="username")
	private String username;
	
	@Column(name="twosteppass")
	private String twosteppass;

	public int getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTwosteppass() {
		return twosteppass;
	}

	public void setTwosteppass(String twosteppass) {
		this.twosteppass = twosteppass;
	}
	
}
