package com.centroxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.centroxy.model.UserDtls;
import com.centroxy.repository.UserRepository;
@Service
public class UserServiceIImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Override
	public UserDtls createUser(UserDtls user) {
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
	 
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		 
		
		return userRepo.existsByEmail(email);
	}

}
