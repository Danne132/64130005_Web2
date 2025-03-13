package com.duyan.HelloSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getMethod() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(ModelMap model, HttpServletRequest request) {
		String email = request.getParameter("email");
		
		return "index";
	}
}
