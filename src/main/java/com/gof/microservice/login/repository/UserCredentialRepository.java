package com.gof.microservice.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gof.microservice.login.entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer>{

	Optional<UserCredential> findByName(String username);

}
