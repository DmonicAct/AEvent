package com.pucp.aevent.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.pucp.aevent.entity.Evento;
import com.pucp.aevent.entity.Persona;
import com.pucp.aevent.entity.Preferencia;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.request_objects.PaginaRequest;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IPreferenciaService;

@RestController
@RequestMapping("/api")
public class PreferenciaApi {
	@Autowired 
	IPreferenciaService service;
	
	//@Secured({"ROLE_ORGANIZER","ROLE_ADMIN","ROLE_DEFAULT"})
	@GetMapping(path = "/preferencia/propuestas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarAllPropuestas(Persona usuario,PaginaRequest page) {

		ResponseObject response = new ResponseObject();
		try {
			List<Preferencia> lista = this.service.findByUsuario(usuario,PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			//System.out.print(""+lista.get(0).getIdPropuesta()+"\n");
			response.setResultado(lista);
			response.setPaginacion(service.getPaginacion());
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
	
	//@Secured({"ROLE_ORGANIZER"})
	@PostMapping(path = "/preferencia",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardarPreferencia( @Valid @RequestBody Preferencia preferencia) {
		ResponseObject response = new ResponseObject();
		try {
			Preferencia preferenciaResult;
			preferenciaResult = this.service.save(preferencia);
			response.setResultado(preferenciaResult);
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

	@GetMapping(path = "/preferencia/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarByUsuarioAndPropuesta(Usuario usuario, Propuesta propuesta) {
		ResponseObject response = new ResponseObject();
		try {
			Preferencia resultado= this.service.findByUsuarioAndPropuesta(usuario, propuesta);
			response.setResultado(resultado);
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
	
	@GetMapping(path = "/preferencia/propuesta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarByPropuesta(Propuesta propuesta,PaginaRequest page) {
		ResponseObject response = new ResponseObject();
		try {
			List<Preferencia> resultado= this.service.findByPropuesta(propuesta, PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(resultado);
			response.setPaginacion(service.getPaginacion());
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
	
	@GetMapping(path = "/preferencia/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> eliminarPreferencia(@PathVariable("id")Long id) {
		ResponseObject response = new ResponseObject();
		try {
			this.service.deleteById(id);;
			response.setResultado(null);
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
