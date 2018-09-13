package com.tabcorp.app.betsapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.tabcorp.app.betsapplication.data.User;

public interface UserRepository extends  CrudRepository<User, Long>{

	User findByUsername(String username);
}
