package com.tc.app.betsapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.tc.app.betsapplication.data.User;

public interface UserRepository extends  CrudRepository<User, Long>{

	User findByUsername(String username);
}
