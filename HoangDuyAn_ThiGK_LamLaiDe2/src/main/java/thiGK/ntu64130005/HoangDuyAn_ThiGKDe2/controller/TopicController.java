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
import thiGK.ntu64130005.HoangDuyAn_ThiGKDe2.model.Topic;

@Controller
@RequestMapping("/topic")
public class TopicController {
	ArrayList<Topic> topics = new ArrayList<>();
	
	public TopicController() {
		topics.add(new Topic("T01", "AI Research", "Study on deep learning and AI models", "GV01", "Research"));
        topics.add(new Topic("T02", "IoT Smart Home", "Build a smart home system using IoT", "GV02", "Project"));
        topics.add(new Topic("T03", "Mobile App Dev", "Develop an Android app for task management", "GV03", "Development"));
        topics.add(new Topic("T04", "Cybersecurity", "Analysis of modern cybersecurity threats", "GV04", "Research"));
        topics.add(new Topic("T05", "Web Application", "Create a full-stack web app using Spring Boot", "GV05", "Project"));
	}
	
	@GetMapping("/all")
	public String getAllTopic(ModelMap model) {
		model.addAttribute("topics", topics);
		return "topiclists";
	}
	
	@GetMapping("/new")
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
	
	@GetMapping("/delete/{id}")
	public String deleteTopic(@PathVariable("id") String id,ModelMap model) {
		for (Topic topic : topics) {
			if(topic.getId().equals(id)) {
				topics.remove(topic);
				break;
			}
		}
		return "redirect:/all";
	}
	
	@GetMapping("/view/{id}")
	public String viewPage(@PathVariable("id") String id, ModelMap model) {
	    for (Topic topic : topics) {
	        if (topic.getId().equals(id)) {
	            model.addAttribute("topic", topic);
	            break;
	        }
	    }
	    return "topicview";
	}
}
