package com.project.springboot.todo.login;

import org.springframework.stereotype.Component;

//@Component
public class AuthenticationService {
	public boolean authenticate(String username) {
boolean isValidUserName=username.equalsIgnoreCase("hari");

return isValidUserName;
	}

}
