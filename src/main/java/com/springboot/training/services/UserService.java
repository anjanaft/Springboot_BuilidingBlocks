package com.springboot.training.services;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.training.entity.User;
import com.springboot.training.exception.UserExistsException;
import com.springboot.training.exception.UserNotFoundException;
import com.springboot.training.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User createUser(User user) throws UserExistsException {
		User existingUser = userRepo.getByUsername(user.getUsername());
		if(existingUser != null) throw new UserExistsException("User already exists");
		return userRepo.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent()) { throw new UserNotFoundException("User doesn't exists");}
		return user;
	}
	
	public User updateUserById(User user , Long id) throws UserNotFoundException {
		Optional<User> optUser = userRepo.findById(id);
		if(!optUser.isPresent()) throw new UserNotFoundException("User doesn't exist");
		
		user.setId(id);
		return userRepo.save(user);
	}
	public void deleteUserById(Long id) throws UserNotFoundException {
		Optional<User> optUser = userRepo.findById(id);
		if(!optUser.isPresent()) throw new UserNotFoundException("User doesn't exist");
		
		userRepo.deleteById(id);
		 
	}
	public User getByUserName(String username) {
		return userRepo.getByUsername(username);
	}

}
