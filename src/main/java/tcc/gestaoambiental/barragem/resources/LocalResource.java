package tcc.gestaoambiental.barragem.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tcc.gestaoambiental.barragem.models.Local;
import tcc.gestaoambiental.barragem.repository.LocalRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Local")
public class LocalResource {
	
	@Autowired
	LocalRepository localRepository;		
	
	@ApiOperation(value="Retorna uma lista de Locais")
	@GetMapping("/locais")
	public Iterable<Local> list(){
		return localRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um local unico")
	@GetMapping("/local/{nome}")
	public Local get(@PathVariable(value="nome") String nome) {
		return localRepository.findByNome(nome);
	}
	
	@ApiOperation(value="Salva um local")
	@PostMapping("/local")
	public Local post(@RequestBody @Valid Local local) {
		return localRepository.save(local);
	}
	
	@ApiOperation(value="Deleta um local")
	@DeleteMapping("/local/{nome}")
	public void delete(@PathVariable(value="nome") String nome) {
		Local local = localRepository.findByNome(nome);
		
		if (local == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado");
		
		localRepository.delete(local);
	}
	
	@ApiOperation(value="Deleta todos os locais")
	@DeleteMapping("/locais/delete")
	public void delete() {
		localRepository.deleteAll();
	}
	
	@ApiOperation(value="Atualiza um local")
	@PutMapping("/local")
	public Local update(@RequestBody @Valid Local local) {
		return localRepository.save(local);
	}
	
}