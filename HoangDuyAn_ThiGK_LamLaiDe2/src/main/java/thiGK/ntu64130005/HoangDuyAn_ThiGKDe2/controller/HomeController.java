package thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.model.Student;
import thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.model.Topic;

@Controller
public class HomeController {

    
	@GetMapping("/")
	public String getHome() {
		return "dashboard";
	}
}
