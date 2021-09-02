package br.com.calculadora.RestWithspringcalculadora.Exception.hanlder;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.calculadora.RestWithspringcalculadora.Exception.ExceptionResponse;
import br.com.calculadora.RestWithspringcalculadora.Exception.UnsuportedMathOperationException;

@ControllerAdvice
@RestController
public class ConstumizeReponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerAllException(Exception ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsuportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handlerBadRequestException(Exception ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}


}
