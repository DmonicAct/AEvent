package com.pucp.aevent.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.pucp.aevent.entity.RespuestaCriterio;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IRespuestaCriterioService;
import com.pucp.aevent.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class RespuestaCriterioApi {

	@Autowired
	IRespuestaCriterioService service;
	
	@Autowired
	IUsuarioService serviceUsuario;
	
	@Secured({"ROLE_ORGANIZER","ROLE_DEFAULT"})
	@GetMapping(path = "/respuestaCriterio/{id}/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarRespuestaCriterio(@PathVariable("id")Integer id,@PathVariable("username")String username) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = null;
			List<RespuestaCriterio> respuestaCriterio= null;
			if(username!=null) {
				usuario = this.serviceUsuario.findByUsername(username);	
				respuestaCriterio = this.service.findByIdEvaluador(usuario.getIdUsuario(),id);
			}
			response.setResultado(respuestaCriterio);
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
	
	@Secured({"ROLE_ORGANIZER","ROLE_DEFAULT"})
	@PostMapping(path = "/respuestaCriterio/guardar/{username}",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardarRespuestaCriterio( @Valid @RequestBody RespuestaCriterio respuestaCriterio,@PathVariable("username")String username) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = null;
			if(username!=null) {
				usuario = this.serviceUsuario.findByUsername(username);	
				if(usuario!=null) {
					respuestaCriterio.setIdEvaluador(usuario.getIdUsuario());
				}
			}
			respuestaCriterio = this.service.save(respuestaCriterio);
			response.setResultado(respuestaCriterio);
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
	
	
	
	@Secured({"ROLE_ORGANIZER","ROLE_DEFAULT"})
	@PostMapping(path = "/respuestaCriterio/test/guardar/{username}",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardarRespuestaCriterio_test( @Valid @RequestBody List<RespuestaCriterio> respuestaCriterio,@PathVariable("username")String username) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = null;
			if(username!=null) {
				usuario = this.serviceUsuario.findByUsername(username);	
				if(usuario!=null) {
					for(RespuestaCriterio r: respuestaCriterio)
						r.setIdEvaluador(usuario.getIdUsuario());
				}
			}
			for(RespuestaCriterio r: respuestaCriterio)
				r.setIdRespuestaCriterio(this.service.save(r).getIdRespuestaCriterio());
			response.setResultado(respuestaCriterio);
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
	
	
	@Secured({"ROLE_ORGANIZER","ROLE_DEFAULT"})
	@PostMapping(path = "/respuestaCriterio/test/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarRespuestaCriterio_test(@Valid @RequestBody List<Integer> ids,@PathVariable("username")String username) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = null;
			List<RespuestaCriterio> respuestaCriterio= new ArrayList<RespuestaCriterio>();
			if(username!=null) {
				usuario = this.serviceUsuario.findByUsername(username);	
				for(int id:ids)
					respuestaCriterio.addAll(this.service.findByIdEvaluador(usuario.getIdUsuario(),id));
			}
			response.setResultado(respuestaCriterio);
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
