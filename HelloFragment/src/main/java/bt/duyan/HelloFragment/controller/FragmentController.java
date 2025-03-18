package bt.duyan.HelloFragment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentController {
	
	@GetMapping("/")
	public String getView() {
		return "index";
	}
}
