package idat.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.com.dto.ProfesorDTORequest;
import idat.com.dto.ProfesorDTOResponse;
import idat.com.service.ProfesorService;



@RestController
@RequestMapping("/profesor/api1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTOResponse>> listarProfesor(){
		
		return new ResponseEntity<List<ProfesorDTOResponse>>(service.findAllProfesor(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProfesorDTORequest profesor){
		
		
		
		service.saveProfesor(profesor);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ProfesorDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ProfesorDTOResponse p = service.findByIdProfesor(id);
		if(p != null)
			return new ResponseEntity<ProfesorDTOResponse>(p, HttpStatus.OK);
		
		return new ResponseEntity<ProfesorDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ProfesorDTORequest profesor){
		
		ProfesorDTOResponse p = service.findByIdProfesor(profesor.getIdProfesorDTO());

		if(p != null) {
			service.editProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProfesorDTOResponse p = service.findByIdProfesor(id);
		if(p != null) {
			service.deleteProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}

}