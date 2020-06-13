package tcc.gestaoambiental.barragem;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BarragemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BarragemApplication.class, args);
	}
	
	@Value("${queue.name}")
    private String queue;

	@Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

}
