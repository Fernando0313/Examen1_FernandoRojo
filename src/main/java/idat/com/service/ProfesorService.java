package idat.com.service;

import java.util.List;

import idat.com.dto.ProfesorDTORequest;
import idat.com.dto.ProfesorDTOResponse;



public interface ProfesorService {
	public void saveProfesor(ProfesorDTORequest profesor);
	public void editProfesor(ProfesorDTORequest profesor);
	
	public void deleteProfesor(Integer id);
	
	public List<ProfesorDTOResponse> findAllProfesor();
	public ProfesorDTOResponse findByIdProfesor(Integer id);

}
