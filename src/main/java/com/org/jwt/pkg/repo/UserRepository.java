package com.org.jwt.pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.jwt.pkg.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);

}
