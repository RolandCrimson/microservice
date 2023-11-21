package com.adacho.rpsgame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adacho.rpsgame.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByAlias(final String alias);
}
