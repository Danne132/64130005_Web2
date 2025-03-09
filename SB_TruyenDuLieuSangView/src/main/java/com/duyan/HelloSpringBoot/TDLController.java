package com.duyan.HelloSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TDLController {
	
	@GetMapping("/")
	public String getMethodName(ModelMap model) {
		model.addAttribute("MSSV", "64130005");
		model.addAttribute("HoTen", "Hoàng Duy An");
		model.addAttribute("NamSinh", "2004");
		model.addAttribute("GioiTinh", "Nam");
		return new String();
	}
	
}
