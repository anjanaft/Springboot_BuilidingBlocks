package com.springboot.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.training.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	User getByUsername(String username);
}
