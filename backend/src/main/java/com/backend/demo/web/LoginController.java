package com.backend.demo.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.domain.UserEntity;
import com.backend.demo.dto.MessageDto;
import com.backend.demo.dto.StatusEnum;
import com.backend.demo.service.LoginService;

@RestController
public class LoginController {
	@Resource(name="LoginService") 
	LoginService loginService;
    @PostMapping("/login")
	public ResponseEntity<MessageDto> userLogin(@RequestBody Map<String,Object> Data) {
        UserEntity user = loginService.getUser(Data);
		MessageDto message = new MessageDto();
		Map <String,Object> result = new HashMap<>();
		result.put("email", "");
		result.put("password","");
		if(user == null){ // 아이디에 해당하는 유저 없음
			message.setStatus(StatusEnum.NOT_FOUND);
			message.setMessage("해당 아이디의 유저가 없습니다.");
		} else if(!user.getPassword().equals(Data.get("password"))){
			message.setStatus(StatusEnum.NOT_FOUND);
			message.setMessage("비밀번호를 확인하세요.");
		} else {
			message.setStatus(StatusEnum.OK);
			message.setMessage("유저 찾기 성공");
			result.put("email",user.getEmail());
			result.put("password",user.getPassword());
		}
		message.setData(result);
		return new ResponseEntity<MessageDto>(message,HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<MessageDto> userSignUp(@RequestBody Map<String,Object> Data) {
		UserEntity user = loginService.insertUser(Data);
		MessageDto message = new MessageDto();
		Map <String,Object> result = new HashMap<>();
		if(user == null){
			message.setStatus(StatusEnum.NOT_FOUND);
			message.setMessage("회원가입실패");
		} else {
			message.setStatus(StatusEnum.OK);
			message.setMessage("회원가입성공");
		}
		message.setData(result);
		return new ResponseEntity<MessageDto>(message,HttpStatus.OK);
	}
}
