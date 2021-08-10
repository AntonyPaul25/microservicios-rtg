package cr.microservicios.rtg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import cr.microservicios.commons.entity.ClienteRequest;
import cr.microservicios.rtg.client.RtgFeignClient;
import cr.microservicios.rtg.entity.ResponseRatingClient;

@Service
public class ClienteRtgSericeImpl implements ClienteRtgSerice {

	@Autowired
	private RtgFeignClient clienteRTG;

	@Override
	public ResponseRatingClient obtenerRating(HttpHeaders headerMap, ClienteRequest client) {
		return clienteRTG.obtenerRating(headerMap, client);
	}

}
