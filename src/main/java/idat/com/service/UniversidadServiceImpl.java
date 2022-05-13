package idat.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.model.Universidad;
import idat.com.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService{

	@Autowired
	private UniversidadRepository repo;
	@Override
	public void saveUniversidad(Universidad universidad) {
		// TODO Auto-generated method stub
		repo.save(universidad);
	}

	@Override
	public void editUniversidad(Universidad universidad) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(universidad);
	}

	@Override
	public void deleteUniversidad(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Universidad> findAllUniversidad() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Universidad> universidadFindById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
