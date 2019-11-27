package com.pucp.aevent.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.pucp.aevent.entity.Categoria;
import com.pucp.aevent.entity.Correo;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.ICategoriaService;
import com.pucp.aevent.service.ICorreoService;

@RestController
@RequestMapping("/api")
public class CorreoApi {
	
	@Autowired
	ICorreoService service;
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(path="/obtenerCredCorreo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarCorreoActual(){
		ResponseObject response = new ResponseObject();
		try {
			Correo correo = this.service.get();
			response.setResultado(correo);
			response.setEstado(Estado.OK);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		}
		catch(BadRequest e) {
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
		} catch(InternalServerError e) {
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception e) {
			response.setError(1, "Error Interno", e.getMessage());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping(path="/modificarCredCorreo/{username}/{pass}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> modificarCorreoActual(@PathVariable("username")String u ,
			@PathVariable("pass")String p){
		ResponseObject response = new ResponseObject();
		try {
			Correo c = new Correo();
			c.setIdCorreo(1);
			c.setUsername(u);
			c.setTwosteppass(p);
			
			Correo correo = this.service.save(c);
			response.setResultado(c);
			response.setEstado(Estado.OK);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		}
		catch(BadRequest e) {
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
		} catch(InternalServerError e) {
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception e) {
			response.setError(1, "Error Interno", e.getMessage());
			response.setEstado(Estado.ERROR);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}