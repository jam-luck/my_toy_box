package com.backend.demo.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.domain.UserEntity;
import com.backend.demo.domain.UserRepository;
@RestController
public class TestController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/ping")
	public String getPing() {
		return "connected!";
	}
	@GetMapping("/user")
	public List<UserEntity> showUser() {
		return userRepository.findAll().stream().toList();
	}
	@GetMapping(value="/user/{name}")
	public void addUser() {
		UserEntity user = UserEntity.builder()
				.name("test")
				.userId("test")
				.userPwd("test")
				.type("user")
				.build();
		userRepository.save(user);
	}
}
