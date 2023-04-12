package com.project.springboot.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		
		return "HELLO,HOW are you doing?";
	}
	
	
	@RequestMapping("say-hellojsp")
	public String sayHelloJsp() {
		
		return "sayHello";
	}

}
