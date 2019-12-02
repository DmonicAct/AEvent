package com.pucp.aevent.service;

import com.pucp.aevent.entity.Email;

public interface IEmailService {
	public Integer enviarMensaje(String destinatario, String asunto, String texto);
	public Integer enviarMensajeFormato(String destinatario, String asunto, String texto);
	public Email pick();
}