package com.backend.demo.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.domain.UserEntity;
import com.backend.demo.service.LoginService;

@RestController
public class LoginController {
	@Resource(name="LoginService") 
	LoginService loginService;
    @PostMapping("/login")
	public Map<String,Object> userLogin(@RequestBody Map<String,Object> Data) {
        UserEntity user = loginService.getUser(Data);
		Map <String, Object> result = new HashMap<String, Object>();
		if(user == null){
			result.put("email", "");
			result.put("password","");
		} else {
			result.put("email",user.getEmail());
			result.put("password",user.getPassword());
		}
		return result;
	}

	@PostMapping("/signup")
	public Map<String,Object> userSignUp(@RequestBody Map<String,Object> Data) {
		UserEntity user = loginService.insertUser(Data);
		Map <String, Object> result = new HashMap<String, Object>();
		if(user == null){
			result.put("email", "");
			result.put("password","");
		} else {
			result.put("email",user.getEmail());
			result.put("password",user.getPassword());
		}
		return result;
	}
}
