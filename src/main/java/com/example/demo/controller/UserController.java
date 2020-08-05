package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.users.Users;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userJpaRepository;
	
	@GetMapping(value="/all")
	public List<Users> findAll(){
		return userJpaRepository.findAll();
		
	}
	
	@GetMapping(value="/{name}")
	public Users findByName(@PathVariable final String name) {
		
		return userJpaRepository.findByName(name);
	}
	
	@PostMapping(value="/load")
	public Users load(@RequestBody final Users users)
	{
		userJpaRepository.save(users);
		return userJpaRepository.findByName(users.getName());
	}

}
