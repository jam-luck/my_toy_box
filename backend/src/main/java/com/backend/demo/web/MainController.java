package com.backend.demo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.backend.demo.service.MainService;

@Controller("MainController")
public class MainController {
	@Resource(name="MainService") 
	MainService mainService;
}
