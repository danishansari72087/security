package com.nagarro.security.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
@Component
public class JwtRequest  {

	@NotNull(message = "username filed in mandatory")
	private String username;
	
	@NotNull(message = "password filed in mandatory")
	private String password;
	
	public JwtRequest()
	{
		
	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}