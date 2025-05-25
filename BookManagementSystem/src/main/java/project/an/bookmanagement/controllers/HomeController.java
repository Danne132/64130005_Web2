package project.an.bookmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.services.AuthorService;
import project.an.bookmanagement.services.BookService;
import project.an.bookmanagement.services.CategoryService;


@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/")
	public String getHome( @RequestParam(name = "sort", required = false) String sort,
						   @RequestParam(name = "searchStr", required = false) String search,
						   @RequestParam(defaultValue = "1") int page,
			ModelMap model) {
		int pageSize = 12;
		Page<Book> sachList = bookService.searchBookFromHome(search, sort, page, pageSize);

        model.addAttribute("data", sachList.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", sachList.getTotalPages());

        model.addAttribute("currentSort", sort);
        model.addAttribute("currentSearch", search);

        model.addAttribute("theloais", categoryService.getAllCategory());
        model.addAttribute("nhaxuatbans", authorService.getAllAuthor());

		return "home/index";
	}
	
	
	
}
