package com.backend.demo.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

	
	@GetMapping("/ping")
	public String getPing() {
		return "connected";
	}
}
