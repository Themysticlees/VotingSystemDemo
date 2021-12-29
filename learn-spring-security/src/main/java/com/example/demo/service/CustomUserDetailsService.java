package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.Usersecurity;
import com.example.demo.repo.UserRepo;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// TODO Auto-generated method stub
		
		Usersecurity user = this.repo.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("User not found!!!");
		
		return new CustomUserDetails(user);
	}

}
