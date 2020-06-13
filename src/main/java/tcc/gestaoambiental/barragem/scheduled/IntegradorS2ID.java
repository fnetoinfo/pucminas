package tcc.gestaoambiental.barragem.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component 
@EnableScheduling
public class IntegradorS2ID {
 
    private final long HORA = 1000 * 60 * 60;

    @Scheduled(fixedDelay = HORA) 
    public void verificaPorHora() { 
        // Código que realiza a consulta 
    }
}
