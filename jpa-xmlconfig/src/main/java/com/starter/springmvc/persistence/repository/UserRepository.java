package com.starter.springmvc.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.starter.springmvc.persistence.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
