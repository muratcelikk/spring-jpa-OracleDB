package com.cal.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cal.pro.model.UserModel;
import com.cal.pro.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/create")
	public ResponseEntity<Object> createUser(@RequestBody UserModel model) {
		return userService.createUser(model);
	}
}
