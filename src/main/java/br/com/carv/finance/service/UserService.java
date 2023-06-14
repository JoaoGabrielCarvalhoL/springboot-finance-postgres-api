package br.com.carv.finance.service;

import java.util.UUID;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;

import br.com.carv.finance.model.dto.request.UserPostRequest;
import br.com.carv.finance.model.dto.request.UserPutRequest;
import br.com.carv.finance.model.dto.response.UserResponse;

public interface UserService {
	
	UserResponse authenticate(String username, String password);
	
	EntityModel<UserResponse> save(UserPostRequest userPostRequest);
	
	void update(UserPutRequest userPutRequest);
	
	void delete(UUID uuid);
	
	UserResponse findById(UUID uuid);
	
	Page<EntityModel<UserResponse>> findAll(Pageable pageable);
	
	void validateEmail(String email); 
	
	void validateUsername(String username);

}
