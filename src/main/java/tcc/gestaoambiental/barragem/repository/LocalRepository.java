package tcc.gestaoambiental.barragem.repository;

import org.springframework.data.repository.CrudRepository;

import tcc.gestaoambiental.barragem.models.Local;

public interface LocalRepository extends CrudRepository<Local, String>{
	Local findByNome(String id);
}
