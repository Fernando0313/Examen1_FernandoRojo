package idat.com.service;

import java.util.List;

import idat.com.dto.ProfesorDTORequest;
import idat.com.dto.ProfesorDTOResponse;



public interface ProfesorService {
	public void guardarProfesor(ProfesorDTORequest profesor);
	public void editarProfesor(ProfesorDTORequest profesor);
	
	public void eliminarProfesor(Integer id);
	
	public List<ProfesorDTOResponse> listarProfesor();
	public ProfesorDTOResponse obtenerProfesorId(Integer id);

}
