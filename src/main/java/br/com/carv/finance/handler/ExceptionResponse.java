package br.com.carv.finance.handler;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ExceptionResponse(String title, Integer Status, String details, LocalDateTime timestamp) implements Serializable {

}
