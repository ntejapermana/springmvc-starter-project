package com.starter.springmvc.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.starter.springmvc.persistence.domain.Authority;
import com.starter.springmvc.persistence.domain.AuthorityKey;

public interface AuthorityRepository extends CrudRepository<Authority, AuthorityKey> {

}
