package com.duyan.HelloSpringBoot.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.duyan.HelloSpringBoot.model.SinhVien;
@Controller
public class TDLController {
	@GetMapping("/truyenObject")
	public String getObject(ModelMap model) {
		SinhVien sinhVien = new SinhVien("64130005", "Hoàng Duy An", "Nam", 2004);
		model.addAttribute("sv", sinhVien);
		return "index";
	}
	
	@GetMapping("/truyenDSObject")
	public String getObjectList(ModelMap model) {
		ArrayList<SinhVien> sinhViens = new ArrayList<SinhVien>(Arrays.asList(
				new SinhVien("64131234", "Hà Thị Kiều Ngân", "Nữ", 2004),
				new SinhVien("64130005", "Hoàng Duy An", "Nam", 2004),
				new SinhVien("64130004", "Dương Thị Ánh Hồng", "Nữ", 2004),
				new SinhVien("64130003", "Hoàng Duy An", "Nam", 2004)
				));
		model.addAttribute("svs", sinhViens);
		return "dsView";
	}
	
}

