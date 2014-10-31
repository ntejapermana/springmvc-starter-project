package com.starter.springmvc.service;

import java.util.List;

import com.starter.springmvc.web.dto.UserData;

public interface UserAdministrationService {
	
	public List<UserData> findAllUsers();

}
