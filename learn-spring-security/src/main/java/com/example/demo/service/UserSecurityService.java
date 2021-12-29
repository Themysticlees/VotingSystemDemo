package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.Service;


import com.example.demo.model.Usersecurity;

@Service
public class UserSecurityService {
	
	List<Usersecurity> list = new ArrayList<>();

	public UserSecurityService() {
		list.add(new Usersecurity("abc","1234","abc@gmail.com"));
		list.add(new Usersecurity("xyz","1234","xyz@gmail.com"));

	}
	
	//get all users
	public List<Usersecurity> getAllUsers(){
		return this.list;
	}
	
	//get single user
	public Usersecurity getUser(String userName) {
		
		for(Usersecurity user :list)
		{
			if(user.getUsername().equalsIgnoreCase(userName))
				return user;
		}
		return null;
	}
	
	//add user
	public Usersecurity addUser(Usersecurity user) {
		list.add(user);
		
		return user;
	}
	
	
	

}
