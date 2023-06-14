package br.com.carv.finance.service.impl;

import java.util.UUID;

import org.jboss.logging.Logger;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.carv.finance.exception.ResourceAlreadyUsedException;
import br.com.carv.finance.mapper.UserMapper;
import br.com.carv.finance.model.dto.request.UserPostRequest;
import br.com.carv.finance.model.dto.request.UserPutRequest;
import br.com.carv.finance.model.dto.response.UserResponse;
import br.com.carv.finance.repository.UserRepository;
import br.com.carv.finance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final Logger logger = Logger.getLogger(UserServiceImpl.class.getSimpleName());
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository; 
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserResponse authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityModel<UserResponse> save(UserPostRequest userPostRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserPutRequest userPutRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserResponse findById(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EntityModel<UserResponse>> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateEmail(String email) {
		Boolean existsByEmail = this.userRepository.existsByEmail(email);
		if (existsByEmail) {
			throw new ResourceAlreadyUsedException("Email Already Used");
		}
	}

	@Override
	public void validateUsername(String username) {
		Boolean existsByUsername = this.userRepository.existsByUsername(username);
		if (existsByUsername) {
			throw new ResourceAlreadyUsedException("Username already used");
		}
	}
}
