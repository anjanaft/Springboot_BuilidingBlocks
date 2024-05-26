package com.springboot.training.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.training.entity.User;
import com.springboot.training.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> getAll(){
		return service.getAllUsers();
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping("user/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long Id) {
		return service.getUserById(Id);
	}
	
	@PutMapping("user/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable("id") Long id) {
		return service.updateUserById(user, id);
	}
	
	@DeleteMapping("user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id){
		service.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("username/{username}")
	public User getByUsername(@PathVariable("username") String username) {
		return  service.getByUserName(username);
		
	}

}
