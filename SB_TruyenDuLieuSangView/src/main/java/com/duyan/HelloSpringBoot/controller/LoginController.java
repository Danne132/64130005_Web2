package com.duyan.HelloSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.duyan.HelloSpringBoot.model.SinhVien;

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
		String pass = request.getParameter("password");
		if(!(email.equals("duyanhoang05@gmail.com") && pass.equals("12345"))) {
			model.addAttribute("message", "Email hoặc mật khẩu không đúng!");
			return "login";
		}
		return "index";
	}
}
