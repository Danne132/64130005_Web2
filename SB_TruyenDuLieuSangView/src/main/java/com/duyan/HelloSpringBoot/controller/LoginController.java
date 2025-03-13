package com.duyan.HelloSpringBoot.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duyan.HelloSpringBoot.model.SinhVien;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getMethod(ModelMap model) {
		model.addAttribute("message", "");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request) {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		if(!(email.equals("duyanhoang05") && pass.equals("12345"))) {
			model.addAttribute("message", "Email hoặc mật khẩu không đúng!");
			return "login";
		}
		SinhVien sVien = new SinhVien("64130005", "Hoàng Duy An", "Nam", 2004);
		model.addAttribute("sv", sVien);
		return "index";
	}
}
