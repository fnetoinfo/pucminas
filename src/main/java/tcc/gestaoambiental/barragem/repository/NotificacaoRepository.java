package tcc.gestaoambiental.barragem.repository;

import org.springframework.data.repository.CrudRepository;

import tcc.gestaoambiental.barragem.models.Notificacao;

public interface NotificacaoRepository extends CrudRepository<Notificacao, String>{
	
}
