package project.an.bookmanagement.controllers;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.models.Catergory;
import project.an.bookmanagement.services.AuthorService;
import project.an.bookmanagement.services.BookService;
import project.an.bookmanagement.services.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String getDashBoard(ModelMap model) {
		long bookCount = bookService.countBookInStore();
		long authorCount = authorService.countAuthor();
		long lowerThan50 = bookService.CountBookFewer();
		long outStock = bookService.CountBookOutStock();
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("authorCount", authorCount);
		model.addAttribute("low", lowerThan50);
		model.addAttribute("out", outStock);
		return "dashboard";
	}
	
	@GetMapping("/sach")
	public String getBook(@RequestParam(name = "sort", required = false) String sort,
							@RequestParam(name = "searchString", required = false) String search,
            				@RequestParam(defaultValue = "1") int page,
            				ModelMap model) {
		Page<Book> sachList = bookService.searchBooks(search, page, sort);
	    model.addAttribute("sachList", sachList);
	    model.addAttribute("searchString", search);
		return "bookview/index";
	}
	
	@GetMapping("/sach/detail/{id}")
	public String getBookDetail(@PathVariable Integer id,
								ModelMap model) {
		Optional<Book> book = bookService.findBookById(id);
		model.addAttribute("book", book.get());
		return "/bookview/detail";
	}
	
	@GetMapping("/category")
	public String getCategory(ModelMap model) {
		List<Catergory> catergories = categoryService.getAllCategory();
		model.addAttribute("categories", catergories);
		return "category/index";
	}
}
