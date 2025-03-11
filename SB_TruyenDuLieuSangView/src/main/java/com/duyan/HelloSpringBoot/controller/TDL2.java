package com.duyan.HelloSpringBoot.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TDL2 {
	@GetMapping("/truyenObject")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}
