package com.pucp.aevent.service.impl;

import java.sql.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.pucp.aevent.dao.IEmailDao;
import com.pucp.aevent.entity.Email;
import com.pucp.aevent.service.IEmailService;

@Component
public class EmailService implements IEmailService {
	@Autowired
    public JavaMailSender emailSender;
	
	private Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
	public IEmailDao emailDao;
	
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
	    } catch (Exception e) {
	    	logger.error("Error en mensajeria: enviarMensaje " + e.getMessage());
	    	logger.error("Error en mensjeria: enviarMensaje" +e.getCause());
	    	System.out.print(e.getMessage());
	    	return 0;
	    }
	    return 1;
	    
	}
	
	
	@Override
	public Integer enviarMensajeFormato(String destinatario, String asunto, String texto) {
	    try {
	    	MimeMessage message = emailSender.createMimeMessage();
	    	Properties props = new Properties();
	    	props.put("mail.smtp.host", "smtp.gmail.com");
	    	props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.port", "587");
	    	
	        Email e = emailDao.findByIdEmail(1);
	        
	        String user = e.getDireccion();
	        String pass = e.getPass();
	        Session mailSession = Session.getInstance(props,
	        		new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                      return new PasswordAuthentication(user, pass);
	                }
                }
	        );
	        message = new MimeMessage(mailSession);
	        message.setFrom(new InternetAddress(user,"Gestión de eventos AEvent"));
	    	
	        InternetAddress[] addresses = 
	        		new InternetAddress[] {new InternetAddress(destinatario)};
	        message.setRecipients(Message.RecipientType.TO,addresses);
	        message.setSubject(asunto);
	        
	        MimeMultipart multipart = new MimeMultipart("related");
	        BodyPart messageBodyPart = new MimeBodyPart();
	        
	        String htmlText = texto;
	        
	        messageBodyPart.setContent(htmlText, "text/html");
	        
	    	multipart.addBodyPart(messageBodyPart);
	    	
	    	message.setContent(multipart);
		    
		    Transport.send(message);
	    } catch (Exception e) {
	    	logger.error("Error en mensajeria: enviarMensaje " + e.getMessage());
	    	logger.error("Error en mensjeria: enviarMensaje" +e.getCause());
	    	System.out.print(e.getMessage());
	    	return 0;
	    }
	    return 1;
	    
	}
	
	@Override
	public Email pick() {
		return emailDao.findByIdEmail(1);
	}
	
}
