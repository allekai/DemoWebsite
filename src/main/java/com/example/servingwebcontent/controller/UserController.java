package com.example.servingwebcontent.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/login")
	public String getUserLogin() {
		return (String) getCurrentUser();
	}
		
		
	public Object getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getPrincipal();
	}
	
	@GetMapping("/user")
	public String userPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("userName", auth.getName());
		return "user/user";
	}
		
}
