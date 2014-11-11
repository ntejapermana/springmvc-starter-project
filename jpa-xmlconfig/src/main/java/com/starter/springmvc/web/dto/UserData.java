package com.starter.springmvc.web.dto;

import java.util.ArrayList;
import java.util.List;

public class UserData {
	
	private String username;
	private String password;
	private int enabled;
	
	private List<String> authorities;
	
	public UserData() {}

	public UserData(String username, String password, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public void addAuthority(String authority) {
		this.authorities.add(authority);
	}
}
