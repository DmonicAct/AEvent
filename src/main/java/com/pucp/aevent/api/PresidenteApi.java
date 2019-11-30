package com.pucp.aevent.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.pucp.aevent.entity.request_objects.PostulacionPropuestaRequest;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IPresidenteService;

@RestController
@RequestMapping("/api")
public class PresidenteApi {

	@Autowired
	IPresidenteService service;
	
	@Secured({"ROLE_ORGANIZER","ROLE_DEFAULT"})
	@GetMapping(path = "/presidente/revisiones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarRevisionesPendientes(int idPresidente) {
		ResponseObject response = new ResponseObject();
		try {
			PostulacionPropuestaRequest pp = this.service.obtenerPostulacionesEnEsperaYPropuestas(idPresidente);
			response.setResultado(pp);
			response.setEstado(Estado.OK);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		} catch(BadRequest e) {
			//response.setError(this.service.getError());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
		} catch(InternalServerError e) {
			//response.setError(this.service.getError());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception e) {
			response.setError(1, "Error Interno", e.getMessage());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
