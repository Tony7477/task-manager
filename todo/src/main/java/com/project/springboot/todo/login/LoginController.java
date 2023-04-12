package com.project.springboot.todo.login;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Controller
//@SessionAttributes("name")
public class LoginController {
//	@Autowired
	private AuthenticationService authenticationService;
	private Logger logger=LoggerFactory.getLogger(getClass());
	//@RequestMapping("login")
	public String gotoLogin(@RequestParam String name,ModelMap model) {
		//to use name1 in jsp
		model.put("name1", name);
		logger.debug("his name is {}",name);
		logger.info("his name is {}",name);
		//logger.warn("his name is {}",name);
		//System.out.println(name); not recommended logging
		
		return "login";
	}
//	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	//only this is being used we can ignore other methods in this controller class
//	@RequestMapping(value="/",method = RequestMethod.GET)
	public String login(ModelMap map) {
		map.put("name",getLoggedinUsername());
		return "welcome";
	}
	private String getLoggedinUsername() {
		org.springframework.security.core.Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
	}
//	@RequestMapping(value="login",method=RequestMethod.POST)
	public String gotoWelcome(@RequestParam String name,ModelMap model) {
		
		if(authenticationService.authenticate(name)) {
			model.put("name", name);
			
			return "welcome";
		}
		model.put("errorMessage", "Invalid credentials please enter valid details");
		return "login";
		
		
	}
}
