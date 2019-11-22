package com.pucp.aevent.service;

public interface IEmailService {
	public Integer enviarMensaje(String destinatario, String asunto, String texto);
	public Integer enviarMensajeFormato(String destinatario, String asunto, String texto);
}