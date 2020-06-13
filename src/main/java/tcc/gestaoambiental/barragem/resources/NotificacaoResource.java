package tcc.gestaoambiental.barragem.resources;

import javax.validation.Valid;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tcc.gestaoambiental.barragem.messages.NotificacaoMessage;
import tcc.gestaoambiental.barragem.models.Local;
import tcc.gestaoambiental.barragem.models.Notificacao;
import tcc.gestaoambiental.barragem.repository.LocalRepository;
import tcc.gestaoambiental.barragem.repository.NotificacaoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Notificação")
public class NotificacaoResource {
	
	@Autowired
	NotificacaoRepository notificacaoRepository;
	
	@Autowired
	LocalRepository localRepository;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
    @Autowired
    private Queue queue;
	
	@ApiOperation(value="Salva uma notificaçao")
	@PostMapping("/notificacao")
	public Notificacao post(@RequestBody @Valid NotificacaoMessage message) {
		
		Local local = localRepository.findByNome(message.getLocal());
		
		if (local == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado");		
		
		rabbitTemplate.convertAndSend(this.queue.getName(), message.getMensagem());		
		
		Notificacao notificacao = new Notificacao();
		notificacao.setLocal(message.getLocal());
		notificacao.setMensagem(message.getMensagem());
		notificacao.setNivel(message.getNivel());
		notificacaoRepository.save(notificacao);
		
		local.setNotificacao(notificacao);
		
		localRepository.save(local);
		
		return notificacao;
	}
	
}