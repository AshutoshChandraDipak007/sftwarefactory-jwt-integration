package com.org.jwt.pkg.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.jwt.pkg.model.User;
import com.org.jwt.pkg.repo.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	List<User> userList;
	
	@PostConstruct
	private void saveUser() {
		userList=Arrays.asList(new User(123,"ashutosh","ashutosh"),new User(124,"ashu","ashu"));
		userRepo.saveAll(userList);
	}

}
