package com.springboot.training.Controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<URI> createUser(@RequestBody User user) {
		try {
			
			service.createUser(user);
			URI loc = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(user.getId())
					.toUri();
			return new ResponseEntity<URI>(loc,HttpStatus.CREATED);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@GetMapping("user/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long Id)  {
		try {
			return service.getUserById(Id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
	}
	
	@PutMapping("user/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable("id") Long id) {
		try {
			return service.updateUserById(user, id);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@DeleteMapping("user/{id}")
	public void deleteUserById(@PathVariable("id") Long id){
		try {
			service.deleteUserById(id);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		}
		
		
	@GetMapping("username/{username}")
	public User getByUsername(@PathVariable("username") String username) {
		return  service.getByUserName(username);
		
	}

}
