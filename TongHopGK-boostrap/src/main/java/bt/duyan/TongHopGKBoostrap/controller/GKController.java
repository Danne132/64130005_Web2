package bt.duyan.TongHopGKBoostrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GKController {
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
}
