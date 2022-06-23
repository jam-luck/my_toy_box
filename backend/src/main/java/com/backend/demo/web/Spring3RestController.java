package com.backend.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Spring3 에서는 @RestController가 없어서 이렇게 구현했었음. 
@Controller
public class Spring3RestController {
	
	@ResponseBody
	@RequestMapping(value="/spring3/{input}",method = RequestMethod.GET)
	public Object getKeyWord(@PathVariable("input") String input) {
		return input;
	}
}
