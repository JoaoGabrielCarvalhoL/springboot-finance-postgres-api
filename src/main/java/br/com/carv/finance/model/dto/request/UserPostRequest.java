package br.com.carv.finance.model.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserPostRequest(
		
		@NotBlank(message = "Name cannot be empty") 
		@Size(max = 100, min = 5, message = "Maximum number of characters for this field is 100.")
		String name,
		
		@Email
		@NotBlank(message = "Email cannot be empty.")
		String email,
		
		@NotBlank(message = "Username cannot be empty.") 
		@Size(max = 100, min = 5, message = "Maximum number of characters for this field is 100.")
		String username, 
		
		@NotBlank(message = "Username cannot be empty.")
		String password,
		
		@NotBlank(message = "Username cannot be empty.")
		@CPF
		String documentCertificatePerson,
		
		String cep,
		
		String cellphone,
		
		LocalDate birthDate) implements Serializable {

}
