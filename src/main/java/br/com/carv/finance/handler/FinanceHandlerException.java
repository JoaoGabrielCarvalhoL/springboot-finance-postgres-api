package br.com.carv.finance.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.carv.finance.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class FinanceHandlerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllException(Exception exception) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse("Internal Server Error", 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleAllException(ResourceNotFoundException exception) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse("Internal Server Error", 
						HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		String field = errors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
		String messageError = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
		ExceptionMessageValidatorResponse exceptionMessageValidatorResponse = 
				new ExceptionMessageValidatorResponse("Bad Request", status.value(), "Check the field(s) error(s)", 
						field, messageError, LocalDateTime.now());
		return new ResponseEntity<>(exceptionMessageValidatorResponse, headers, status);
	}


}
