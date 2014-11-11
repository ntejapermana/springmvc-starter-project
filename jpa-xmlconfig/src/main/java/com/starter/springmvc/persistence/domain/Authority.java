package com.starter.springmvc.persistence.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
@IdClass(AuthorityKey.class)
public class Authority implements Serializable {

	private static final long serialVersionUID = 9217829865157275604L;

	@Id
	private String username;
	@Id
	private String authority;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
	private User user;
		
	public Authority() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}

