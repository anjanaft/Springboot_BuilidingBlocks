package com.springboot.training.services;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.training.entity.User;
import com.springboot.training.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}
	
	public User updateUserById(User user , Long id) {
		user.setId(id);
		return userRepo.save(user);
	}
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
		 
	}
	public User getByUserName(String username) {
		return userRepo.getByUsername(username);
	}

}
