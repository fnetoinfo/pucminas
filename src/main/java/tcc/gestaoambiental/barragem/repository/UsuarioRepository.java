package tcc.gestaoambiental.barragem.repository;

import org.springframework.data.repository.CrudRepository;

import tcc.gestaoambiental.barragem.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
}
