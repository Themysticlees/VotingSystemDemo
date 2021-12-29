package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Usersecurity;
import com.example.demo.repo.UserRepo;


@SpringBootApplication
@EnableWebSecurity
public class LearnSpringSecurityApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringSecurityApplication.class, args);
	}
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Usersecurity user1= new Usersecurity();
		user1.setUsername("gunjan");
		user1.setEmail("gunjanganguly@gmail.com");
		user1.setPassword(passwordEncoder.encode("1234"));
		user1.setRole("ROLE_ADMIN");
		
		
		this.userRepo.save(user1);
		
		Usersecurity user2= new Usersecurity();
		user2.setUsername("surya");
		user2.setEmail("suryasekhar@gmail.com");
		user2.setPassword(passwordEncoder.encode("1234"));
		user2.setRole("ROLE_USER");
		
		
		this.userRepo.save(user2);
	}

}
