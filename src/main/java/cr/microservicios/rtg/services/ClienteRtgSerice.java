package cr.microservicios.rtg.services;

import org.springframework.http.HttpHeaders;

import cr.microservicios.commons.entity.ClienteRequest;
import cr.microservicios.rtg.entity.ResponseRatingClient;

public interface ClienteRtgSerice {

	public ResponseRatingClient obtenerRating(HttpHeaders headerMap, ClienteRequest client);
	
	

}
