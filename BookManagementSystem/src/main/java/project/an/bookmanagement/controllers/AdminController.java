package project.an.bookmanagement.controllers;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.an.bookmanagement.models.Book;
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
		long lowerThan50 = bookService.CountBookFewer();
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("authorCount", authorCount);
		model.addAttribute("low", lowerThan50);
		return "dashboard";
	}
	
	@GetMapping("/sach")
	public String getBook(@RequestParam(name = "searchString", required = false) String search,
            				@RequestParam(defaultValue = "1") int page,
            				ModelMap model) {
		Page<Book> sachList = bookService.searchBooks(search, page);
	    model.addAttribute("sachList", sachList);
	    model.addAttribute("searchString", search);
		return "bookview/index";
	}
}
