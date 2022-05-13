package idat.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.MallaDTORequest;
import idat.com.dto.MallaDTOResponse;
import idat.com.model.MallaCurricular;
import idat.com.repository.MallaRepository;


@Service
public class MallaServiceImpl implements MallaService {

	@Autowired
	public MallaRepository repositorio;

	@Override
	public void saveMalla(MallaDTORequest malla) {

	       MallaCurricular m = new MallaCurricular();
			m.setIdMalla(malla.getIdMallaDTO());
			m.setAnio(malla.getAnioDTO());
			
			repositorio.save(m);
		
	}

	@Override
	public void editMalla(MallaDTORequest malla) {
		MallaCurricular m = new MallaCurricular();
m.setIdMalla(malla.getIdMallaDTO());
m.setAnio(malla.getAnioDTO());
repositorio.saveAndFlush(m);
		
	}

	@Override
	public void deleteMalla(Integer id) {
		 repositorio.deleteById(id);
		
	}

	@Override
	public List<MallaDTOResponse> findAllMalla() {
		List<MallaDTOResponse> lista = new ArrayList<MallaDTOResponse>();
		MallaDTOResponse m = null;
		
		for(MallaCurricular malla :repositorio.findAll()) {
			m = new MallaDTOResponse();
			
			m.setIdMallaDTO(malla.getIdMalla());
			m.setAnioDTO(malla.getAnio());
			
			lista.add(m);
		}
		
		return lista;
	}
	

	@Override
	public MallaDTOResponse findByIdMalla(Integer id) {
		
		MallaCurricular malla = repositorio.findById(id).orElse(null);
		MallaDTOResponse m = new MallaDTOResponse();
		m.setIdMallaDTO(malla.getIdMalla());
		m.setAnioDTO(malla.getAnio());
		
		return m;
	
	}
	
}
