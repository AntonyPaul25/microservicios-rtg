package cr.microservicios.rtg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EntityScan({ "cr.microservicios.commons.entity" })
public class MicroserviciosRtgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRtgApplication.class, args);
	}

}
