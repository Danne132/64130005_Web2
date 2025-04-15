package thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
}
