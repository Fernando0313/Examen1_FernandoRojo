package idat.com.service;

import java.util.List;

import idat.com.dto.MallaDTORequest;
import idat.com.dto.MallaDTOResponse;


public interface MallaService {
	
	public void guardarMalla(MallaDTORequest malla);
	public void editarMalla(MallaDTORequest malla);
	
	public void eliminarMalla(Integer id);
	
	public List<MallaDTOResponse> listarMalla();
	public MallaDTOResponse obtenerMallaId(Integer id);

}
