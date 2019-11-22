package com.pucp.aevent.util;

public class UtilMessage {
	/*Mensaje de ponencia*/
	public static final String PARAMETRO_NOMBRECOMPLETO = "{{NombreCompleto}}";
	public static final String PARAMETRO_TITULOEVENTO = "{{TituloEvento}}";
	public static final String MENSAJE_PONENTE_INSCRIPCION = "<p>" + 
			"   Usted," + 
			"   <i> {{NombreCompleto}}, </i>" + 
			"   <b> se ha registrado satisfactoriamente en el evento</b>" + 
			"   <i> {{TituloEvento}}. </i>" +
			"</p>";
	public static final String MENSAJE_PONENTE_CONFIRMACION = "Confirmación de registro de propuesta";
	//
}
