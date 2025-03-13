package bt.duyan.BMIDiemCong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller class BMIController {
	
	@GetMapping("/")
	public String getMethodName() {
		return "index";
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
			if (bmi < 18.5) return "Gầy";
            else if (bmi < 23) return "Bình thường";
            else if (bmi < 27.5) return "Thừa cân";
            else return "Béo phì";
		}
		else {
            if (bmi < 18.5) return "Gầy";
            else if (bmi < 25) return "Bình thường";
            else if (bmi < 30) return "Thừa cân";
            else return "Béo phì";
        }
	}
}
