package idat.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.Universidad;
@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer>{

}
