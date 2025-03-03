package bt.an.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
//	@RequestMapping("/")
//	public ModelAndView getPage() {
//		ModelAndView m = new ModelAndView();
//		m.setViewName("welcome");
//		return m;
//	}
	@RequestMapping("/")
	public String getPage() {
		String m = "welcome";
		return m;
	}
}
