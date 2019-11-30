package com.pucp.aevent.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.pucp.aevent.entity.Evaluacion;
import com.pucp.aevent.entity.Fase;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.RespuestaCriterio;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.request_objects.PaginaRequest;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IEmailService;
import com.pucp.aevent.service.IEvaluacionService;
import com.pucp.aevent.service.impl.EmailService;

@RestController
@RequestMapping("/api")
public class EvaluacionApi {
	
	@Autowired 
	IEvaluacionService evservice;
	
	@Autowired
	IEmailService emailserv;
	
	@Secured({"ROLE_ORGANIZER","ROLE_ADMIN","ROLE_DEFAULT"})
	@PostMapping(path = "/evaluacion",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> asignarEvaluadorAPropuesta(Persona evaluador,Propuesta propuesta,Fase fase){
		ResponseObject response = new ResponseObject();
		try {
			Evaluacion e = this.evservice.asignarPropuesta(evaluador,propuesta,fase);
			response.setResultado(e);
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
	
	@Secured({"ROLE_ORGANIZER","ROLE_ADMIN","ROLE_DEFAULT"})
	@GetMapping(path = "/evaluacion/desasignar/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> desasignarPropuesta(@PathVariable("id") int id){
		ResponseObject response = new ResponseObject();
		try {
			//evaluacion.setSigueEvaluando(false);
			this.evservice.desasignar(id);
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
	
	
	@Secured({"ROLE_ORGANIZER","ROLE_ADMIN","ROLE_DEFAULT"})
	@GetMapping(path = "/evaluaciones",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> recibirEvaluaciones(Persona evaluador, PaginaRequest page){
		//id es el id del evaluador
		ResponseObject response = new ResponseObject();
		try {
			List<Evaluacion> lista = this.evservice.findAllByEvaluador(evaluador,PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(lista);
			response.setPaginacion(evservice.getPaginacion());
			response.setEstado(Estado.OK);
			/*
			emailserv.enviarMensaje("a20143250@pucp.edu.pe", "SALUDO", "<b>This text is bold</b>");
			emailserv.enviarMensajeFormato("a20143250@pucp.edu.pe", "SALUDO", "<b>This text is bold</b>");
			
			emailserv.enviarMensaje("andreco_2610@hotmail.com", "SALUDO", "<b>This text is bold</b>");
			emailserv.enviarMensajeFormato("andreco_2610@hotmail.com", "SALUDO", "<b>This text is bold</b>");
			*/
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
	

	@Secured({"ROLE_ORGANIZER","ROLE_ADMIN","ROLE_DEFAULT"})
	@GetMapping(path = "/evaluaciones/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> obtenerEvaluacion( @PathVariable("id") int id) {
		ResponseObject response = new ResponseObject();
		try {
			Evaluacion eva = this.evservice.findByIdEvaluacion(id);	
				//response.setResultado();
			response.setResultado(eva);
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
	
	@Secured({"ROLE_ORGANIZER"})
	@PostMapping(path = "/evaluaciones/guardar",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardarEvaluacion( @Valid @RequestBody Evaluacion evaluacion) {
		ResponseObject response = new ResponseObject();
		try {
			this.evservice.save(evaluacion);
			//response.setResultado(respuestaCriterio);
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
	
	@Secured({"ROLE_ORGANIZER","ROLE_ADMIN","ROLE_DEFAULT"})
	@GetMapping(path = "/evaluaciones/propuesta",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> obtenerEvaluacionByPropuesta(Propuesta propuesta) {
		ResponseObject response = new ResponseObject();
		try {
			List<Evaluacion> eva = this.evservice.findAllByPropuesta(propuesta);
			response.setResultado(eva);
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