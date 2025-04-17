package thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	ArrayList<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("S01", "Nguyen Van A", "G01"));
        students.add(new Student("S02", "Tran Thi B", "G01"));
        students.add(new Student("S03", "Le Van C", "G02"));
        students.add(new Student("S04", "Pham Thi D", "G02"));
        students.add(new Student("S05", "Hoang Van E", "G03"));
    }
    
    @GetMapping("/all")
	public String getAllStudent(ModelMap model) {
		model.addAttribute("students", students);
		return "studentlists";
	}
	
	@GetMapping("/new")
	public String getNewStudent() {
		return "studentadd";
	}
	
	@RequestMapping(value="/addstudent", method = RequestMethod.POST)
	public String addNewStudent(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String groupId = request.getParameter("group");
		Student student = new Student(id, name, groupId);
		students.add(student);
		model.addAttribute("students", students);
		return "studentlists";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") String id,ModelMap model) {
		for (Student student : students) {
			if(student.getId().equals(id)) {
				students.remove(student);
				break;
			}
		}
		return "redirect:/all";
	}
	
	@GetMapping("/students/view/{id}")
	public String viewStudent(@PathVariable("id") String id, ModelMap model) {
	    for (Student student : students) {
	        if (student.getId().equals(id)) {
	            model.addAttribute("student", student);
	            break;
	        }
	    }
	    return "studentview";
	}
}
