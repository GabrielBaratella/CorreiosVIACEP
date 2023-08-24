package br.com.baratellagabriel.correios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Serviço está em instalação, favor aguarde.")
public class NotReadyException extends Exception {
	
	
	

}
