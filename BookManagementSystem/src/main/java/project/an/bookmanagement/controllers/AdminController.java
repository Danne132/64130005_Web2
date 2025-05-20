package project.an.bookmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.an.bookmanagement.services.AuthorService;
import project.an.bookmanagement.services.BookService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/")
	public String getDashBoard(ModelMap model) {
		long bookCount = bookService.countBookInStore();
		long authorCount = authorService.countAuthor();
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("authorCount", authorCount);
		return "dashboard";
	}
}
