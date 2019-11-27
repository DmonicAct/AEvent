package com.pucp.aevent.service;

import java.util.List;

import com.pucp.aevent.entity.Correo;

public interface IEmailService {
	public Integer enviarMensaje(String destinatario, String asunto, String texto);
	public Integer enviarMensajeFormato(Correo cred, 
			String destinatario, 
			String asunto, 
			String texto);
}