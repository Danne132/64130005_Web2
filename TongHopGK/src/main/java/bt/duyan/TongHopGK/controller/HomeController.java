package bt.duyan.TongHopGK.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bt.duyan.TongHopGK.model.Student;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
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
		return "newStudent";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request) {
		String mssv = request.getParameter("mssv");
		String hoTen = request.getParameter("hoTen");
		double diemTB = Double.parseDouble(request.getParameter("diemTB"));
		Student student = new Student(mssv, hoTen, diemTB);
		sinhViens.add(student);
		model.addAttribute("sv", sinhViens);
		return "list";
	}
}
