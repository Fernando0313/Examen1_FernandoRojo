package idat.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import idat.com.model.Universidad;
import idat.com.service.UniversidadService;

@RestController
@RequestMapping("/universidad/api1")
public class UniversidadController {
	
	@Autowired
	private UniversidadService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listaruniversidad(){
		
		return new ResponseEntity<List<Universidad>>(service.findAllUniversidad(), HttpStatus.OK);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad){
		
		
		
		service.saveUniversidad(universidad);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Optional<Universidad>> listarPorId(@PathVariable Integer id) {
		
		Optional<Universidad> u = service.universidadFindById(id);
		if(u != null)
			return new ResponseEntity<Optional<Universidad>>(u, HttpStatus.OK);
		
		return new ResponseEntity<Optional<Universidad>>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Universidad universidad){
		
		Optional<Universidad> u = service.universidadFindById(universidad.getIdUniversidad());

		if(u != null) {
			service.editUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		Optional<Universidad> u = service.universidadFindById(id);
		if(u != null) {
			service.deleteUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}

}
