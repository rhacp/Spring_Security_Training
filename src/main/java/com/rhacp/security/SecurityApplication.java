package com.rhacp.security;

import com.rhacp.security.models.Role;
import com.rhacp.security.models.User;
import com.rhacp.security.repository.RoleRepository;
import com.rhacp.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
		return args -> {
			Role adminRole = new Role("ADMIN");
			roleRepository.save(adminRole);

			Role userRole = new Role("USER");
			roleRepository.save(userRole);

			Set<Role> roleSet = new HashSet<>(Set.of(adminRole));
			User user = new User("Ion", "ion", passwordEncoder.encode("1234"), roleSet);
			userRepository.save(user);
		};
	}
}
