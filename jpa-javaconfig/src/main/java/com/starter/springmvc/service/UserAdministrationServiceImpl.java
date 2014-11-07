package com.starter.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.springmvc.persistence.domain.Authority;
import com.starter.springmvc.persistence.domain.User;
import com.starter.springmvc.persistence.repository.UserRepository;
import com.starter.springmvc.web.dto.UserData;

@Service
public class UserAdministrationServiceImpl implements UserAdministrationService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserData> findAllUsers() {
		List<UserData> userData = new ArrayList<>();
		for(User user : userRepository.findAll()) {
			UserData data = new UserData(user.getUsername(), user.getPassword(), user.getEnabled());
			for(Authority auth : user.getRoles()) {
				data.addAuthority(auth.getAuthority());
			}
			userData.add(data);
		}
		return userData;
	}

}
