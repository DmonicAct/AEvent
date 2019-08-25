package com.aevent.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aevent.model.response_objects.Estado;
import com.aevent.model.response_objects.ResponseObject;
import com.aevent.service.ISampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class sampleApi {
	
	@Autowired
	private ISampleService service;
	
	@GetMapping(path = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> consultarAsuntos(){
		ResponseObject response = new ResponseObject();
//		List<Integer> lista = new ArrayList<Integer>();
//		for(int i=0; i<10; i++) {
//			lista.add(i);
//		}
		response.setResultado(service.getList());
		response.setEstado(Estado.OK);
		return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
	}
}
