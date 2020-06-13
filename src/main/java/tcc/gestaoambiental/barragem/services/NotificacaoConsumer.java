package tcc.gestaoambiental.barragem.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoConsumer {
	 
    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
       System.out.println("Enviando um e-mail com o conteúdo " + fileBody);
    }
}