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

import idat.com.dto.CursoDTORequest;
import idat.com.dto.CursoDTOResponse;
import idat.com.service.CursoService;


@RestController
@RequestMapping("/curso/apiv1")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>> listarCurso(){
		
		return new ResponseEntity<List<CursoDTOResponse>>(service.findAllCursos(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody CursoDTORequest curso){
		
		
		
		service.saveCurso(curso);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<CursoDTOResponse> listarPorId(@PathVariable Integer id) {
		
		CursoDTOResponse p = service.CursoFindById(id);
		if(p != null)
			return new ResponseEntity<CursoDTOResponse>(p, HttpStatus.OK);
		
		return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody CursoDTORequest curso){
		
		CursoDTOResponse p = service.CursoFindById(curso.getIdCursoDTO());

		if(p != null) {
			service.editCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		CursoDTOResponse p = service.CursoFindById(id);
		if(p != null) {
			service.deleteCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}
}
