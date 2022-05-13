package idat.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.CursoDTORequest;
import idat.com.dto.CursoDTOResponse;
import idat.com.model.Curso;
import idat.com.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	public CursoRepository repositorio;

	@Override
	public void guardarCurso(CursoDTORequest curso) {
		Curso c = new Curso();
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		repositorio.save(c);
	}

	@Override
	public void editarCurso(CursoDTORequest curso) {
		Curso c = new Curso();
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		repositorio.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<CursoDTOResponse> listarCursos() {
		List<CursoDTOResponse> lista = new ArrayList<CursoDTOResponse>();
		CursoDTOResponse c = null;
		
		for(Curso curso :repositorio.findAll()) {
			c = new CursoDTOResponse();
			
			c.setCursoDTO(curso.getCurso());
			c.setDescripcionDTO(curso.getDescripcion());
			c.setIdCursoDTO(curso.getIdCurso());
			
			lista.add(c);
		}
		
		
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCursoId(Integer id) {

		Curso curso = repositorio.findById(id).orElse(null);
		CursoDTOResponse c = new CursoDTOResponse();
		c.setCursoDTO(curso.getCurso());
		c.setDescripcionDTO(curso.getDescripcion());
		c.setIdCursoDTO(curso.getIdCurso());
		return c;
	}

}
