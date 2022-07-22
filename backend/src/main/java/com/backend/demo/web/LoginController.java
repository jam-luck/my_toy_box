package com.backend.demo.web;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
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
		MessageDto message = new MessageDto();
		Map <String,Object> result = new HashMap<>();
		UserEntity user = loginService.getUser(Data);
		result.put("email", "");
		result.put("password","");
		if(user == null){ // 아이디에 해당하는 유저 없음
			message.setStatus(StatusEnum.NOT_FOUND);
			message.setMessage("해당 아이디의 유저가 없습니다.");
		} else if(!user.getPassword().equals(Data.get("password"))){ // 비밀번호 틀린경우
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
		MessageDto message = new MessageDto();
		String regx = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(Data.get("email").toString());
		if(!matcher.matches()){
			message.setMessage("회원가입실패: 잘못된 이메일 형식");
			return new ResponseEntity<MessageDto>(message,HttpStatus.UNAUTHORIZED);
		} 
		pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
		matcher = pattern.matcher(Data.get("password").toString());
		if(!matcher.matches()){
			message.setMessage("회원가입실패: 비밀번호는 영문과 특수문자를 포함한 8자 이상이어야 함");
			return new ResponseEntity<MessageDto>(message,HttpStatus.UNAUTHORIZED);
		}
		UserEntity user = loginService.insertUser(Data);
		if(user == null){
			message.setMessage("회원가입실패: 이미 사용중인 이메일");
			return new ResponseEntity<MessageDto>(message,HttpStatus.UNAUTHORIZED);
		} else {
			message.setMessage("회원가입성공");
			return new ResponseEntity<MessageDto>(message,HttpStatus.OK);
		}
	}
}
