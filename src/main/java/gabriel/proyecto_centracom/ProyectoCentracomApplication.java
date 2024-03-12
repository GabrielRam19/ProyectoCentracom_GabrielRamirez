package gabriel.proyecto_centracom;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan("gabriel.proyecto_centracom.models")
public class ProyectoCentracomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCentracomApplication.class, args);
	}

}
