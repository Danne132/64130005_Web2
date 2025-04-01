package thiGK.ntu64130005.HoangDuyAn_ThiGK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GKController {
	
	@GetMapping("/")
	public String getDashBoard() {
		return "index";
	}
}
