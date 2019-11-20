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
	
	
	@Override
	public Integer enviarMensajeFormato(String destinatario, String asunto, String texto) {
	    try {
	    	MimeMessage message = emailSender.createMimeMessage();
	    	Properties props = new Properties();
	    	
	    	//props.put("mail.protocol", "smtp");
	    	//props.put("mail.port", "587");
	    	
	    	props.put("mail.transport.protocol", "smtp");
	    	props.put("mail.smtp.host", "smtp.gmail.com");
	    	props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        
	    	
	        String user = "aeventmailing@gmail.com";
	        String pass = "somosaevent";
	        Session mailSession = Session.getInstance(props,
	        		new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                      return new PasswordAuthentication(user, pass);
	                }
                }
	        );
	        message = new MimeMessage(mailSession);
	        //msg.setFrom(new InternetAddress(from));
	    	
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
	    }
	    return 0;
	    
	}
	
}
