package com.gof.microservice.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gof.microservice.login.entity.UserCredential;
import com.gof.microservice.login.repository.UserCredentialRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialRepository credentialRepository;
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtService jwtService;
	
	
	public String saveUser(UserCredential credential) {
		credential.setPassword(encoder.encode(credential.getPassword()));
		credentialRepository.save(credential);
		return "user added to the system";
	}
	
	public String generateToken(String userName) {
		System.out.println("userName   :"+userName);
		return jwtService.generateToken(userName);
	}
	
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
		
		
	}
	

}
