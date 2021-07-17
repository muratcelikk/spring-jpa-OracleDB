package com.cal.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cal.pro.entity.User;
import com.cal.pro.model.UserModel;
import com.cal.pro.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity createUser(UserModel model) {
		User user = new User();
		if (userRepository.findByEmail(model.getEmail()).isPresent()) {
			System.out.println("The email is already present");
			return ResponseEntity.badRequest().body("The Email is already Present, Failed to create new user");
		} else {
			user.setFirstname(model.getFirstname());
			user.setLastname(model.getLastname());
			user.setEmail(model.getEmail());
			user.setMobile(model.getMobile());
			userRepository.save(user);
			return ResponseEntity.ok("UserCreated successfully!");
		}
	}
}
