package idat.com.service;

import java.util.List;

import idat.com.dto.CursoDTORequest;
import idat.com.dto.CursoDTOResponse;



public interface CursoService {

	public void guardarCurso(CursoDTORequest curso);
	public void editarCurso(CursoDTORequest curso);
	
	public void eliminarCurso(Integer id);
	
	public List<CursoDTOResponse> listarCursos();
	public CursoDTOResponse obtenerCursoId(Integer id);
}
