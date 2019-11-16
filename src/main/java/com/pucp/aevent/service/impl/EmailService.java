package com.pucp.aevent.service.impl;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.pucp.aevent.service.IEmailService;

@Component
public class EmailService implements IEmailService {
	@Autowired
    public JavaMailSender emailSender;
	
	private Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	
	@Override
	public Integer enviarMensaje(String destinatario, String asunto, String texto) {
	    try {
	    	MimeMessage message = emailSender.createMimeMessage();
	    	System.out.print("\nSe va a enviar correo\n");
	    	MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    	System.out.print("\nMime funca\n");
		    helper.setTo(destinatario);
		    helper.setSubject(asunto);
		    helper.setText(texto);
		    System.out.print("\nSets hechos\n");
		    emailSender.send(message);
		    System.out.print("\nSe va a enviar correo\n");
		    return 1;
	    } catch (Exception e) {
	    	logger.error("Error en mensajeria: enviarMensaje " + e.getMessage());
	    	logger.error("Error en mensjeria: enviarMensaje" +e.getCause());
	    	System.out.print(e.getMessage());
	    }
	    return 0;
	    
	}
}
