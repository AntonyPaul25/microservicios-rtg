package cr.microservicios.rtg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cr.microservicios.commons.entity.LogMDL;

@FeignClient(name = "microservicio-log")
public interface LogFeignClient {

	@PostMapping
	public ResponseEntity<?> save(@RequestBody LogMDL logmdl);

}
