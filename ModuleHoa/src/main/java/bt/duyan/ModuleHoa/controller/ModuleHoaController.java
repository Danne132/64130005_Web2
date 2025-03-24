package bt.duyan.ModuleHoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModuleHoaController {
	
	@GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/bmi")
    public String about() {
        return "bmi";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    @RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String calculateBMI(ModelMap model, 
			@RequestParam("weight") float weight,
			@RequestParam("height") float height,
			@RequestParam(name="isAsian", defaultValue = "false", required = false) boolean isAsian) {
		float mHeight = height/100;
		float bmi = calcBMI(weight, mHeight);
		String message = evaluate(bmi, isAsian);
		float bmiFormat = Math.round(bmi * 100.0f) / 100.0f;
		model.addAttribute("bmi", bmiFormat);
		model.addAttribute("message", message);
		return "index";
	}
	
	private float calcBMI(float weight, float height) {
		return weight / (height * height);
	}
	
	private String evaluate(float bmi, boolean isAsian) {
		if(isAsian) {
			if (bmi < 18.5) return "Underweight";
            if (bmi < 23) return "Normal";
            if (bmi < 25) return "Overweight";
            if (bmi < 30) return "Obesity I";
            else return "Obesity II";
		}
		else {
            if (bmi < 18.5) return "Underweight";
            else if (bmi < 25) return "Normal";
            else if (bmi < 30) return "Overweight";
            else return "Obesity";
        }
	}
}
