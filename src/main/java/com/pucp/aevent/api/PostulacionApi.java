package com.pucp.aevent.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pucp.aevent.entity.Postulacion;
import com.pucp.aevent.entity.Propuesta;
import com.pucp.aevent.entity.RespuestaFormulario;
import com.pucp.aevent.entity.Usuario;
import com.pucp.aevent.entity.request_objects.PaginaRequest;
import com.pucp.aevent.entity.request_objects.RespuestaFormularioxPostulacionRequest;
import com.pucp.aevent.entity.response_objects.Estado;
import com.pucp.aevent.entity.response_objects.ResponseObject;
import com.pucp.aevent.service.IEventoService;
import com.pucp.aevent.service.IPostulacionService;
import com.pucp.aevent.service.IRespuestaFormularioService;
import com.pucp.aevent.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class PostulacionApi {
	@Autowired
	IPostulacionService servicePostulacion;
	
	@Autowired
	IRespuestaFormularioService serviceRespuesta;
	
	@Autowired
	IEventoService serivceEvento;
	
	@Autowired
	IUsuarioService serviceUsuario;
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/postulacion/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarPostulaciones(@PathVariable("idUsuario")Long id,PaginaRequest page) {
		ResponseObject response = new ResponseObject();
		try {
			List<Postulacion> lista = null;
			lista = this.servicePostulacion.findAll(id,PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(lista);
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path="/postulacion/exists/{idUsuario}/{idEvento}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> validarPostulacion(@PathVariable("idUsuario")Long idUsuario,@PathVariable("idEvento")Long idEvento){
		ResponseObject response = new ResponseObject();
		try {
			Boolean flag = this.servicePostulacion.existsPostulacion(idUsuario, idEvento);
			response.setResultado(flag);
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
	@Secured({"ROLE_DEFAULT"})
	@PostMapping(path = "/postulacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardar(@RequestBody RespuestaFormularioxPostulacionRequest object) {
		ResponseObject response = new ResponseObject();
		try {
			List<RespuestaFormulario> lista = object.getListaFormulario();
			Postulacion postulacion = object.getPostulacion();
			
			this.servicePostulacion.save(postulacion);
			if(lista!=null && lista.size()>0)
				for(RespuestaFormulario e : lista) {
					e.setIdPostulacion(postulacion.getIdPostulacion());
					e.setIdEvento(postulacion.getIdEvento());
					e.setIdFase(postulacion.getIdFase());
					this.serviceRespuesta.save(e);
				}
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
	
	/*
	 * Guardado De Formulario para fase
	 * */
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/postulacion/{idUsuario}/{idEvento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> findById(@PathVariable("idUsuario")Long idUsuario,@PathVariable("idEvento")Long idEvento) {
		ResponseObject response = new ResponseObject();
		Map<String,Object> complexObj = new HashMap<>();
		try {
			Postulacion postulacion;
			List<RespuestaFormulario> listaPreguntas;
			postulacion = this.servicePostulacion.findById(idUsuario, idEvento);
			complexObj.put("META_DATA", postulacion);
			
			listaPreguntas = this.serviceRespuesta.findByIdFaseAndIdPostulante(postulacion.getIdFase(), postulacion.getIdPostulacion());
			complexObj.put("LISTA", listaPreguntas);
			
			response.setResultado(complexObj);
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/postulacion/propuesta/{Username}/{idEvento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> findAllPropuesta(@PathVariable("Username")String Username,@PathVariable("idEvento")int idEvento,PaginaRequest page) {
		ResponseObject response = new ResponseObject();
		List<Propuesta> lista = null;
		try {
			Usuario usuario = this.serviceUsuario.findByUsername(Username);
			lista = this.servicePostulacion.findAllPropuesta(usuario, PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(lista);
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
	
	@Secured({"ROLE_DEFAULT"})
	@PostMapping(path = "/postulacion/propuesta/{Username}/{idEvento}", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> savePropuesta(@PathVariable("Username")String Username,@PathVariable("idEvento")int idEvento,@RequestBody Propuesta propuesta) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = this.serviceUsuario.findByUsername(Username);
			Evento evento = this.serivceEvento.findById(idEvento);
			propuesta.setPostulante(usuario);
			propuesta.setEvento(evento);
			Propuesta prop = this.servicePostulacion.savePropuesta(propuesta);
			response.setResultado(prop);
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/propuesta/exists/{Username}/{idEvento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> existsPropuesta(@PathVariable("Username")String Username,@PathVariable("idEvento")int idEvento) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = this.serviceUsuario.findByUsername(Username);
			Boolean exists = this.servicePostulacion.existsPropuesta(usuario.getIdUsuario(), idEvento);
			response.setResultado(exists);
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/propuesta/{Username}/{idEvento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> existsPropuesta_object(@PathVariable("Username")String Username,@PathVariable("idEvento")int idEvento) {
		ResponseObject response = new ResponseObject();
		try {
			Usuario usuario = this.serviceUsuario.findByUsername(Username);
			Evento evento = this.serivceEvento.findById(idEvento);
			Propuesta propuesta = null;
			propuesta = this.servicePostulacion.findByPostulanteAndEvento(usuario, evento);
			response.setResultado(propuesta);
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
