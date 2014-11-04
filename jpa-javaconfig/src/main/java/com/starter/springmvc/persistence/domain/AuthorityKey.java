package com.starter.springmvc.persistence.domain;

import java.io.Serializable;

public class AuthorityKey implements Serializable {
	
	private static final long serialVersionUID = -2695460252981717987L;
	private String username;
	private String authority;
	
	public AuthorityKey() {}
	
	public AuthorityKey(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		return username.hashCode() + authority.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AuthorityKey) {
			AuthorityKey ak = (AuthorityKey)obj;
			return username.equals(ak.username) && authority.equals(ak.authority);
		} else {
			return false;
		}
	}
	
	
	
}
