package br.com.calculadora.RestWithspringcalculadora.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

	private static final long serialVersionId = 1L;
	
	public UnsuportedMathOperationException(String exception) {
		super(exception);
	}
	
}
