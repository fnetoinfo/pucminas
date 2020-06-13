package tcc.gestaoambiental.barragem.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import tcc.gestaoambiental.barragem.models.Role;
import tcc.gestaoambiental.barragem.models.Usuario;
import tcc.gestaoambiental.barragem.repository.RoleRepository;
import tcc.gestaoambiental.barragem.repository.UsuarioRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RoleRepository roleRepository;	
    
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void run(ApplicationArguments args) {
    	
    	Role role = new Role();
    	role.setNomeRole("ADMIN");
    	
    	roleRepository.save(role);
    	
    	List<Role> roles = new ArrayList<>();
    	roles.add(role);
    	
    	Usuario usuario = new Usuario();
		usuario.setLogin("fneto.info@gmail.com");
		usuario.setSenha(new BCryptPasswordEncoder().encode("123"));
		usuario.setRoles(roles);
		
    	usuarioRepository.save(usuario);
    }
}