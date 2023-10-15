package com.gof.microservice.login.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gof.microservice.login.entity.UserCredential;
import com.gof.microservice.login.repository.UserCredentialRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialRepository credentialRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredential > credential= credentialRepository.findByName(username);
		return credential.map(CustomUserdetails :: new ).orElseThrow(() ->
		new UsernameNotFoundException("user not found with name : "+username));
	}

}
