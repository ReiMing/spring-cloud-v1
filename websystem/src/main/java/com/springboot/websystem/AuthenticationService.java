package com.springboot.websystem;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	static String NAME="tim";
	static String PASSWORD="psw";
	
	public boolean authenticate(String name, String password) {
		
		return name.equals(NAME) && password.equals(PASSWORD);
	}
}
