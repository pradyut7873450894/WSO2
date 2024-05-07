package com.centroxy.service;

import com.centroxy.model.UserDtls;

public interface UserService {

	
	public UserDtls createUser(UserDtls user);
	
	public boolean checkEmail(String email);
}
