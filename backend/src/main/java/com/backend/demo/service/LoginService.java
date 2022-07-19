package com.backend.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.domain.UserEntity;
import com.backend.demo.domain.UserRepository;

@Service("LoginService")
public class LoginService {
    @Autowired
    UserRepository userRepository;

    public UserEntity getUser(Map<String,Object> input){
        return userRepository.findByEmail(input.get("email").toString());
    }
    public UserEntity insertUser(Map<String,Object> input){
        UserEntity user = getUser(input);
        if(user == null){
            UserEntity newUser = new UserEntity(input.get("email").toString(),input.get("password").toString(),"1");
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }
}
