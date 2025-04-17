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
	ArrayList<Topic> topics = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();

    public HomeController() {
    	topics.add(new Topic("T01", "AI Research", "Study on deep learning and AI models", "GV01", "Research"));
        topics.add(new Topic("T02", "IoT Smart Home", "Build a smart home system using IoT", "GV02", "Project"));
        topics.add(new Topic("T03", "Mobile App Dev", "Develop an Android app for task management", "GV03", "Development"));
        topics.add(new Topic("T04", "Cybersecurity", "Analysis of modern cybersecurity threats", "GV04", "Research"));
        topics.add(new Topic("T05", "Web Application", "Create a full-stack web app using Spring Boot", "GV05", "Project"));
        students.add(new Student("S01", "Nguyen Van A", "G01"));
        students.add(new Student("S02", "Tran Thi B", "G01"));
        students.add(new Student("S03", "Le Van C", "G02"));
        students.add(new Student("S04", "Pham Thi D", "G02"));
        students.add(new Student("S05", "Hoang Van E", "G03"));
    }
    
	@GetMapping("/")
	public String getHome() {
		return "dashboard";
	}
	
	@GetMapping("/topic/all")
	public String getAllTopic(ModelMap model) {
		model.addAttribute("topics", topics);
		return "topiclists";
	}
	
	@GetMapping("/topic/new")
	public String getNewTopic() {
		return "topicadd";
	}
	
	@RequestMapping(value="/addtopic", method = RequestMethod.POST)
	public String addNewTopic(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String topicName = request.getParameter("topicName");
		String topicdescription = request.getParameter("topicDescription");
		String supervisorId = request.getParameter("supervisor");
		String type = request.getParameter("type");
		Topic topic = new Topic(id, topicName, topicdescription, supervisorId, type);
		topics.add(topic);
		model.addAttribute("topics", topics);
		return "topiclists";
	}
	
	@GetMapping("/topic/delete/{id}")
	public String deleteTopic(@PathVariable("id") String id,ModelMap model) {
		for (Topic topic : topics) {
			if(topic.getId().equals(id)) {
				topics.remove(topic);
				break;
			}
		}
		return "redirect:/topic/all";
	}
	
	@GetMapping("/topic/view/{id}")
	public String viewPage(@PathVariable("id") String id, ModelMap model) {
	    for (Topic topic : topics) {
	        if (topic.getId().equals(id)) {
	            model.addAttribute("topic", topic);
	            break;
	        }
	    }
	    return "topicview";
	}
	
	@GetMapping("/student/all")
	public String getAllStudent(ModelMap model) {
		model.addAttribute("students", students);
		return "studentlists";
	}
	
	@GetMapping("/student/new")
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
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") String id,ModelMap model) {
		for (Student student : students) {
			if(student.getId().equals(id)) {
				students.remove(student);
				break;
			}
		}
		return "redirect:/student/all";
	}
}
