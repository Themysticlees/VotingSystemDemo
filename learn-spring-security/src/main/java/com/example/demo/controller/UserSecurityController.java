package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usersecurity;
import com.example.demo.service.UserSecurityService;

@RestController
@RequestMapping("/users")
public class UserSecurityController {
	
	@Autowired
	UserSecurityService userService;

	//all users
	@GetMapping("/")
	public List<Usersecurity> getUsers(){
		return this.userService.getAllUsers();
		
	}
	
	//return single user
	@GetMapping("/{userName}")
	public Usersecurity getUser(@PathVariable("userName") String userName) {
		return this.userService.getUser(userName);
	}
	
	//for adding user
	@PostMapping("/")
	public Usersecurity addUser(Usersecurity user) {
		return this.addUser(user);
	}
}
