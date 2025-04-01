package bt.duyan.TongHopGKBoostrap.controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bt.duyan.TongHopGKBoostrap.model.*;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GKController {
	ArrayList<Student> sinhViens = new ArrayList<Student>(Arrays.asList(
			new Student("64131234", "Hà Thị Kiều Ngân", 8.5),
			new Student("64130005", "Hoàng Duy An", 9.0),
			new Student("64130004", "Dương Thị Ánh Hồng", 8.6),
			new Student("64130003", "Phạm Trung Kiên", 7.7)
			));
	
	@GetMapping("/")
	public String toHome() {
		return "index";
	}
	
	@GetMapping("/about")
	public String toAbout() {
		return "about";
	}
	
	@GetMapping("/list")
	public String toList(ModelMap model) {
		model.addAttribute("svs", sinhViens);
		return "list";
	}
	
	@GetMapping("/addNew")
	public String toNew(ModelMap model) {
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request) {
		String mssv = request.getParameter("mssv");
		String hoTen = request.getParameter("hoTen");
		double diemTB = Double.parseDouble(request.getParameter("diemTB"));
		Student student = new Student(mssv, hoTen, diemTB);
		sinhViens.add(student);
		model.addAttribute("svs", sinhViens);
		return "list";
	}
	
	@GetMapping("/bmi")
	public String toBMI() {
		return "bmi";
	}
	
	@RequestMapping(value = "/calcBMI", method = RequestMethod.POST)
	public String calculateBMI(ModelMap model, 
			@RequestParam(name = "weight", defaultValue = "0") float weight,
			@RequestParam(name = "height", defaultValue = "0") float height,
			@RequestParam(name="isAsian", defaultValue = "false", required = false) boolean isAsian) {
		float mHeight = height/100;
		String message;
		float bmiFormat;
		if(mHeight == 0 | weight == 0) {
			bmiFormat = Float.NaN;
			message = "Nhập chiều cao và cân nặng";
		}
		else {
			float bmi = calcBMI(weight, mHeight);
			message = evaluate(bmi, isAsian);
			bmiFormat = Math.round(bmi * 100.0f) / 100.0f;
		}
		
		model.addAttribute("bmi", bmiFormat);
		model.addAttribute("message", message);
		return "bmi";
	}
	
	@GetMapping("/calc")
	public String toCalculator() {
		return "maytinh";
	}
	
	private float calcBMI(float weight, float height) {
		return weight / (height * height);
	}
	
	private String evaluate(float bmi, boolean isAsian) {
		if(isAsian) {
			if (bmi < 18.5) return "Thiếu cân";
            if (bmi < 23) return "Bình thường";
            if (bmi < 25) return "Thừa cân";
            if (bmi < 30) return "Béo phì cấp I";
            else return "Béo phì cấp II";
		}
		else {
            if (bmi < 18.5) return "Thiếu cân";
            else if (bmi < 25) return "Bình thường";
            else if (bmi < 30) return "Thừa cân";
            else return "Béo phì";
        }
	}
}
