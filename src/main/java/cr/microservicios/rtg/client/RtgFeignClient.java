package cr.microservicios.rtg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import cr.microservicios.commons.entity.ClienteRequest;
import cr.microservicios.rtg.entity.ResponseRatingClient;

@FeignClient(name = "rtg", url = "https://dpiuat.grupoib.local:7020/ibk/uat/api/enterprise-loan/v1/loan-limit/rating")
public interface RtgFeignClient {

	@PostMapping
	public ResponseRatingClient obtenerRating(@RequestHeader HttpHeaders headerMap,@RequestBody ClienteRequest client);

}
