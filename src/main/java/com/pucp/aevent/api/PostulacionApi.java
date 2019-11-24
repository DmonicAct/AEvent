package com.pucp.aevent.api;

import java.util.ArrayList;
import java.util.List;

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
import com.pucp.aevent.service.IEmailService;
import com.pucp.aevent.service.IEventoService;
import com.pucp.aevent.service.IPostulacionService;
import com.pucp.aevent.service.IRespuestaFormularioService;
import com.pucp.aevent.service.IUsuarioService;
import com.pucp.aevent.util.UtilMessage;

@RestController
@RequestMapping("/api")
public class PostulacionApi {
	@Autowired
	IPostulacionService servicePostulacion;
	
	@Autowired
	IRespuestaFormularioService serviceRespuesta;
	
	@Autowired
	IEventoService serviceEvento;
	
	@Autowired
	IUsuarioService serviceUsuario;
	
	@Autowired
	IEmailService serviceEmail;
	
	
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
	@PostMapping(path = "/postulacion/{Username}", produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> guardar(@RequestBody RespuestaFormularioxPostulacionRequest object,@PathVariable("Username")String Username) {
		ResponseObject response = new ResponseObject();
		try {
			Postulacion postulacion = object.getPostulacion();
			if(postulacion.getIdUsuario()==null) {
				Usuario usuario = this.serviceUsuario.findByUsername(Username);
				postulacion.setIdUsuario(Long.parseLong(String.valueOf(usuario.getIdUsuario())));
			}
			
			List<RespuestaFormulario> lista = object.getListaFormulario();
			this.servicePostulacion.save(postulacion);
			if(lista!=null && lista.size()>0)
				for(RespuestaFormulario e : lista) {
					if(e.getIdPostulacion()==null)
						e.setIdPostulacion(postulacion.getIdPostulacion());
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/postulacion/all/{idPropuesta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> obtenerPostulaciones(@PathVariable("idPropuesta")Long idPropuesta) {
		ResponseObject response = new ResponseObject();
		try {
			List<RespuestaFormularioxPostulacionRequest> lista = null;
			List<Postulacion> listaPostulacion;
			List<RespuestaFormulario> listaRespuesta;
			
			
			listaPostulacion= this.servicePostulacion.findAllByPropuesta(idPropuesta);
		
			lista = new ArrayList<RespuestaFormularioxPostulacionRequest>();
			for(Postulacion element : listaPostulacion) {
				RespuestaFormularioxPostulacionRequest e = new RespuestaFormularioxPostulacionRequest();
				e.setPostulacion(element);
				lista.add(e);
			}
			
			for(RespuestaFormularioxPostulacionRequest element: lista) {
				listaRespuesta = this.servicePostulacion.findAllByPostulacion(element.getPostulacion().getIdPostulacion());
				element.setListaFormulario(listaRespuesta);
			}
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
	/*
	 * Guardado De Formulario para fase
	 * */
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/postulacion/propuesta/{Username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> findAllPropuesta(@PathVariable("Username")String Username,PaginaRequest page) {
		ResponseObject response = new ResponseObject();
		List<Propuesta> lista = null;
		try {
			Usuario usuario = this.serviceUsuario.findByUsername(Username);
			lista = this.servicePostulacion.findAllPropuesta(usuario, PageRequest.of(page.getPaginaFront(), page.getRegistros()));
			response.setResultado(lista);
			response.setEstado(Estado.OK);
			response.setPaginacion(this.servicePostulacion.getPaginacion());
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
			Evento evento = this.serviceEvento.findById(idEvento);
			propuesta.setPostulante(usuario);
			propuesta.setEvento(evento);
			Propuesta prop = this.servicePostulacion.savePropuesta(propuesta);
			
			for(Usuario user: evento.getComite()) {
				
			}
			/*
				Servicio de Email Inicio
			*/
			if(usuario.getEmail()!=null) {
				String texto = UtilMessage.MENSAJE_PONENTE_INSCRIPCION;
				texto.replace(UtilMessage.PARAMETRO_NOMBRECOMPLETO, usuario.getNombreCompleto());
				texto.replace(UtilMessage.PARAMETRO_TITULOEVENTO, evento.getTitulo());
				serviceEmail.enviarMensajeFormato(usuario.getEmail(), 
						UtilMessage.MENSAJE_PONENTE_CONFIRMACION, texto);
			}
			
			/*
				Servicio de Email Fin
			*/
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
			Evento evento = this.serviceEvento.findById(idEvento);
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/propuesta/{idPropuesta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> findPropuestaById(@PathVariable("idPropuesta") Integer idPropuesta){
		ResponseObject response = new ResponseObject();
		try {
			
			Propuesta propuesta = null;
			propuesta = this.servicePostulacion.findByIdPropuesta(idPropuesta);
			Integer idEvento = propuesta.getEvento().getIdEvento();
			if(idEvento!=null) {
				Evento evento = this.serviceEvento.findById(idEvento);
				propuesta.setEvento(evento);
			}
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
	
	@Secured({"ROLE_DEFAULT"})
	@GetMapping(path = "/propuesta/enviar/{idPostulacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> enviarPropuesta(@PathVariable("idPostulacion") Long idPostulacion){
		ResponseObject response = new ResponseObject();
		try {
			Postulacion post = this.servicePostulacion.findByIdPostulacion(idPostulacion);
			post = this.servicePostulacion.enviarPostulacion(post);
			response.setResultado(post);
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
