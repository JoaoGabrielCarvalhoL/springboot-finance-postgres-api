package br.com.carv.finance.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.carv.finance.model.entity.User;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	void init( ) {
		User user = new User("João Gabriel Carvalho", 
				"27.joaogabriel@gmail.com", "joao", "123", "11122233344");
		this.userRepository.save(user);
	}
	
	@AfterEach
	void on_closing() {
		List<User> findAll = this.userRepository.findAll();
		this.userRepository.delete(findAll.get(0));
	}
	
	@Test
	@Order(1)
	public void should_verify_email_existing() {
		Boolean existsByEmail = this.userRepository.existsByEmail("27.joaogabriel@gmail.com");
		Assertions.assertThat(existsByEmail).isTrue();
	}
	
	@Test
	@Order(2)
	public void should_verify_username_existing() {
		Boolean existsByEmail = this.userRepository.existsByUsername("joao");
		Assertions.assertThat(existsByEmail).isTrue();
	}
	
	@Test
	@Order(3)
	public void should_return_user_by_username() {
		User user = this.userRepository.findByUsername("joao");
		Assertions.assertThat(user).isNotNull();
		Assertions.assertThat(user.getUsername()).isEqualTo("joao");
	}

	@Test
	@Order(4)
	public void should_return_user_by_email() {
		User user = this.userRepository.findByEmail("27.joaogabriel@gmail.com");
		Assertions.assertThat(user).isNotNull();
		Assertions.assertThat(user.getEmail()).isEqualTo("27.joaogabriel@gmail.com");
	}
	
	@Test
	@Order(5)
	public void should_verify_email_no_existing() {
		Boolean existsByEmail = this.userRepository.existsByEmail("227.joaogabriel@gmail.com");
		Assertions.assertThat(existsByEmail).isFalse();
	}
	
	@Test
	@Order(6)
	public void should_verify_username_no_existing() {
		Boolean existsByEmail = this.userRepository.existsByUsername("jjjoao");
		Assertions.assertThat(existsByEmail).isFalse();
	}
	
	@Test
	@Order(7)
	public void should_no_return_user_by_username() {
		User user = this.userRepository.findByUsername("jjjoao");
		Assertions.assertThat(user).isNull();
	}

	@Test
	@Order(8)
	public void should_no_return_user_by_email() {
		User user = this.userRepository.findByEmail("227.joaogabriel@gmail.com");
		Assertions.assertThat(user).isNull();
	}
}
