package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.Usersecurity;

public interface UserRepo extends JpaRepository<Usersecurity, String> {
	
	@Query("SELECT u FROM Usersecurity u WHERE u.username = :username")
	public Usersecurity findByUserName(@Param("username")String username);
	
	@Query("SELECT u FROM Usersecurity u WHERE u.username = :username")
	public Usersecurity findByUsername(String username);

}
