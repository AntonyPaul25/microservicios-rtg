package cr.microservicios.rtg.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cr.microservicios.commons.entity.ClienteRequest;
import cr.microservicios.rtg.entity.ResponseRatingClient;
import cr.microservicios.rtg.services.ClienteRtgSerice;

@RestController
public class RtgController {

	@Autowired
	private ClienteRtgSerice servicecliente;

	@PostMapping
	public ResponseEntity<?> prueba(@RequestBody ClienteRequest clientrequest) {

		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Format formatterMessage = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("uBseGenuat", "Ibk2018$");
		headers.add("X-INT-Timestamp", formatter.format(new Date()));
		headers.add("X-IBM-Client-Id", "a3a383ba-3d4d-4a35-a85e-0cd0f09eae26");
		headers.add("X-INT-Service-Id", "ATM");
		headers.add("X-INT-Net-Id", "IS");
		headers.add("X-INT-Branch-Id", "100");
		headers.add("X-INT-Consumer-Id", "ATM");
		headers.add("X-INT-Message-Id", formatterMessage.format(new Date()));
		headers.add("X-INT-User-Id", "BSE0000");

		ResponseRatingClient clientertg = servicecliente.obtenerRating(headers, clientrequest);

		return ResponseEntity.ok(clientertg);
	}

}
