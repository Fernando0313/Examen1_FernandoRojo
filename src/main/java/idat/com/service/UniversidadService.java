package idat.com.service;

import java.util.List;
import java.util.Optional;

import idat.com.model.Universidad;

public interface UniversidadService{

	public void saveUniversidad(Universidad universidad);
	public void editUniversidad(Universidad universidad);
	
	public void deleteUniversidad(Integer id);
	
	public List<Universidad> findAllUniversidad();
	public Optional<Universidad> universidadFindById(Integer id);
}
