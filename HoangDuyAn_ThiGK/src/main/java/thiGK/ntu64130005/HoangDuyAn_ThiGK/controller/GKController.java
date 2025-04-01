package thiGK.ntu64130005.HoangDuyAn_ThiGK.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import thiGK.ntu64130005.HoangDuyAn_ThiGK.model.Page;

@Controller
public class GKController {
	ArrayList<Page> sinhViens = new ArrayList<Page>(Arrays.asList(
			new Page(1, "Home", "home, index", "Đây là trang chủ", 0),
			new Page(2, "About", "about, company", "About Us Page", 1)
			));
	
	
	@GetMapping("/")
	public String getDashBoard() {
		return "index";
	}
	
	@GetMapping("/page/all"){
		return 
	}
}
