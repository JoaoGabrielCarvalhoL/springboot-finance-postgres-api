package br.com.carv.finance.handler;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ExceptionMessageValidatorResponse(
		String title, Integer Status, String details, String field, String message, LocalDateTime timestamp
		) implements Serializable {

}
