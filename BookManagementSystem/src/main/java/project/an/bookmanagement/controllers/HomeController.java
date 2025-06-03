package project.an.bookmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.repositories.BookAuthorRepository;
import project.an.bookmanagement.services.AuthorService;
import project.an.bookmanagement.services.BookAuthorService;
import project.an.bookmanagement.services.BookService;
import project.an.bookmanagement.services.CategoryService;


@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookAuthorService bookAuthorService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/")
	public String getHome( @RequestParam(name = "sort", required = false) String sort,
						   @RequestParam(name = "searchStr", required = false) String search,
						   @RequestParam(name = "pageIndex", defaultValue = "1") int page,
						   @RequestParam(name = "searchAuthor", required = false) String searchAuthor,
						   ModelMap model) {
		int pageSize = 12;
		Page<Book> sachList = bookService.searchBookFromHome(search, sort,page, pageSize, searchAuthor);
		if(searchAuthor != null) {
			Author author = authorService.findByName(searchAuthor);
			model.addAttribute("author",author);
		}
        model.addAttribute("data", sachList.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", sachList.getTotalPages());

        model.addAttribute("currentSort", sort);
        model.addAttribute("currentSearch", search);

        model.addAttribute("theloais", categoryService.getAllCategory());
        model.addAttribute("nhaxuatbans", authorService.getAllAuthor());

		return "home/index";
	}
	
	@GetMapping("/sach/{id}")
	public String getBook(@PathVariable Integer id,
						  ModelMap model) {
		Optional<Book> book = bookService.findBookById(id);
		List<Author> authors = bookAuthorService.findAuthorsByBook(book.get());
		model.addAttribute("authors",authors);
		model.addAttribute("book",book.get());
		return "home/book";
	}
	
}
