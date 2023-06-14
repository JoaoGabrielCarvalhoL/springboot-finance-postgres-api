package br.com.carv.finance.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.finance.model.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	User findByUsername(String username);
	User findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
