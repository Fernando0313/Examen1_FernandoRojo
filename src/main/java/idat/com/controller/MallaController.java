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

import idat.com.dto.MallaDTORequest;
import idat.com.dto.MallaDTOResponse;
import idat.com.service.MallaService;



@RestController
@RequestMapping("/Malla/apiv1")
public class MallaController {
	
	@Autowired
	private MallaService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaDTOResponse>> listarMalla(){
		
		return new ResponseEntity<List<MallaDTOResponse>>(service.findAllMalla(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaDTORequest malla){
		
		
		
		service.saveMalla(malla);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<MallaDTOResponse> listarPorId(@PathVariable Integer id) {
		
		MallaDTOResponse p = service.findByIdMalla(id);
		if(p != null)
			return new ResponseEntity<MallaDTOResponse>(p, HttpStatus.OK);
		
		return new ResponseEntity<MallaDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody MallaDTORequest malla){
		
		MallaDTOResponse p = service.findByIdMalla(malla.getIdMallaDTO());

		if(p != null) {
			service.editMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		MallaDTOResponse p = service.findByIdMalla(id);
		if(p != null) {
			service.deleteMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}

}

