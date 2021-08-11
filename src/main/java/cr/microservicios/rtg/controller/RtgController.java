package cr.microservicios.rtg.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cr.microservicios.commons.entity.ClienteRequest;
import cr.microservicios.commons.entity.LogMDL;
import cr.microservicios.rtg.entity.ResponseRatingClient;
import cr.microservicios.rtg.services.ClienteRtgSerice;
import cr.microservicios.rtg.services.LogMDLService;
import feign.FeignException;

@RestController
public class RtgController {

	@Autowired
	private ClienteRtgSerice servicecliente;

	@Autowired
	private LogMDLService logservice;

	@PostMapping
	public ResponseEntity<?> prueba(@Valid @RequestBody ClienteRequest clientrequest, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			return this.validar(result);
		}

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

		ResponseRatingClient clientertg = new ResponseRatingClient();

		try {
			clientertg = servicecliente.obtenerRating(headers, clientrequest);
		} catch (FeignException feigne) {
			// throw new Exception(feigne.contentUTF8());
			logservice.save(new LogMDL(
					"num solicitud: " + clientrequest.getNumsolicitud().toString() + " -- " + feigne.contentUTF8()));
			return new ResponseEntity<>(feigne.contentUTF8(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// logservice.save(new LogMDL(clientertg.toString()));

		return ResponseEntity.ok(clientertg);
	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}
