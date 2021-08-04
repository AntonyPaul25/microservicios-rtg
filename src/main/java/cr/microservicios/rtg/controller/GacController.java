package cr.microservicios.rtg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GacController {

	@GetMapping
	public ResponseEntity<?> prueba() {
		return ResponseEntity.ok("test RTG");
	}
	
}
