package com.starter.springmvc.persistence.domain.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.starter.springmvc.persistence.domain.Authority;
import com.starter.springmvc.persistence.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 7514432569806247648L;
	
	public SecurityUser(User user) {
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setEnabled(user.getEnabled());
		this.setRoles(user.getRoles());
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return (super.getEnabled() == 1) ? true : false;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Authority> userRoles = this.getRoles();
		if(userRoles != null)
		{
			for (Authority role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getAuthority());
				authorities.add(authority);
			}
		}
		return authorities;
	}

}
