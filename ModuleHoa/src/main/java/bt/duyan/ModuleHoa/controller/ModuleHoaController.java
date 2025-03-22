package bt.duyan.ModuleHoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModuleHoaController {
	
	@GetMapping("/")
	public String getMethod(ModelMap model) {
		return "index";
	}
}
