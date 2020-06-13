package tcc.gestaoambiental.barragem.repository;

import org.springframework.data.repository.CrudRepository;

import tcc.gestaoambiental.barragem.models.Ativo;

public interface AtivoRepository extends CrudRepository<Ativo, String>{
	Ativo findById(long id);
}
