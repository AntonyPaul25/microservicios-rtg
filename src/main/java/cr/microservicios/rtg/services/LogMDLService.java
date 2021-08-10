package cr.microservicios.rtg.services;

import org.springframework.http.ResponseEntity;

import cr.microservicios.commons.entity.LogMDL;

public interface LogMDLService {

	public ResponseEntity<?> save(LogMDL logmdl);
	
}
