package project.an.bookmanagement.controllers;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.ServletContext;
import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.models.Catergory;
import project.an.bookmanagement.services.AuthorService;
import project.an.bookmanagement.services.BookAuthorService;
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
	
	@Autowired
	private BookAuthorService bookAuthorService;
	
	@Value("${upload.dir}")
    private String uploadDir;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/")
	public String getDashBoard(ModelMap model) {
		long bookCount = bookService.countBookInStore();
		long authorCount = authorService.countAuthor();
		long lowerThan50 = bookService.CountBookFewer();
		long outStock = bookService.CountBookOutStock();
		List<Integer> countCategory = bookService.countBookByCategory();
		List<Catergory> catergories = categoryService.getAllCategory();
		List<Author> authors = authorService.findTop5AuthorsByBookCount();
		List<String> categoryNames = catergories.stream()
			.map(Catergory::getCategoryName) .collect(Collectors.toList());
		List<String> authorName = authors.stream()
				.map(Author::getAuthorName) .collect(Collectors.toList());
		List<Long> countAuthor = authors.stream()
				.map(Author::getCountBook) .collect(Collectors.toList());
		model.addAttribute("bookCount", bookCount);
		model.addAttribute("authorCount", authorCount);
		model.addAttribute("low", lowerThan50);
		model.addAttribute("out", outStock);
		model.addAttribute("countCat", countCategory);
		model.addAttribute("labelCat", categoryNames);
		model.addAttribute("countAuthors",countAuthor);
		model.addAttribute("labelAuthors",authorName);
		return "dashboard";
	}
	
	@GetMapping("/sach")
	public String getBook(@RequestParam(name = "sort", required = false) String sort,
							@RequestParam(name = "searchString", required = false) String search,
            				@RequestParam(defaultValue = "1") int page,
            				ModelMap model) {
		Page<Book> sachList = bookService.searchBooks(search, page, sort, 5);
	    model.addAttribute("sachList", sachList);
	    model.addAttribute("searchString", search);
		return "bookview/index";
	}
	
	@GetMapping("/sach/detail/{id}")
	public String getBookDetail(@PathVariable Integer id,
								ModelMap model) {
		Optional<Book> book = bookService.findBookById(id);
	    if (book.isPresent()) {
	        String authorNames = bookAuthorService.getAuthorsStringByBook(book.get());

	        model.addAttribute("book", book.get());
	        model.addAttribute("authorsString", authorNames);
	        return "/bookview/detail";
	    } else {
	        return "redirect:/admin/sach"; // hoặc xử lý khi không tìm thấy sách
	    }
	}
	
	@GetMapping("/sach/create")
	public String getNewBook(ModelMap model) {
		Book book = new Book();
		List<Author> authors = authorService.getAllAuthor();
		List<Catergory> catergories = categoryService.getAllCategory();
		model.addAttribute("authors", authors);
		model.addAttribute("book", book);
		model.addAttribute("categories", catergories);
		return "/bookview/add";
	}
	
	@PostMapping("/sach/create")
    public String createBook(@ModelAttribute Book book,
                             @RequestParam("selectedAuthorIds") List<Integer> authorIds,
                             @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                String uploadPath = servletContext.getRealPath("/uploads"); // trỏ đến webapp/uploads
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                	uploadDir.mkdirs();
                }

                // Lưu file
                File savedFile = new File(uploadPath, filename);
                file.transferTo(savedFile);

                // Lưu đường dẫn ảnh tương đối
                book.setBookImage(filename);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        bookService.SaveBook(book);
        bookAuthorService.saveBookAuthors(book, authorIds);
        return "redirect:/admin/sach";
    }
	
	@GetMapping("/sach/edit/{id}")
	public String editBook(@PathVariable Integer id,
						ModelMap model) {
		Optional<Book> book = bookService.findBookById(id);
		List<Catergory> catergories = categoryService.getAllCategory();
		List<Author> allAuthors = authorService.getAllAuthor();
		List<Author> bookAuthors = bookAuthorService.findAuthorsByBook(book.get());
		model.addAttribute("book",book);
		model.addAttribute("categories", catergories);
		model.addAttribute("authors", allAuthors);
		model.addAttribute("bookAuthors", bookAuthors);
		return "bookview/edit";
	}
	
	@PostMapping("/sach/edit")
	public String saveBook(
	        @ModelAttribute Book book,
	        @RequestParam("authorIds") List<Integer> authorIds,
	        @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			System.out.println("Có ảnh");
	        try {
	        	String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
               
	        	File uploadPath = new File(System.getProperty("user.dir"), uploadDir);
                if (!uploadPath.exists()) {
                    uploadPath.mkdirs();
                }

                // Lưu file
                File savedFile = new File(uploadPath, filename);
                file.transferTo(savedFile);

                // Lưu đường dẫn ảnh tương đối
                book.setBookImage(filename);

	        } catch (IOException e) {
	            e.printStackTrace();
	            // xử lý lỗi hoặc báo lại giao diện
	        }
	    }
		else {
			Book book2 = bookService.findBookById(book.getIdBook()).get();
			book.setBookImage(book2.getBookImage());
		}
	    bookService.SaveBook(book);
	    bookAuthorService.updateAuthorsForBook(book, authorIds);
	    return "redirect:/admin/sach";
	}
	
	@GetMapping("/sach/delete/{id}")
	public String deleteBook(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
	    try {
	        bookService.deleteById(id);
	        redirectAttributes.addFlashAttribute("successMessage", "Xóa sách thành công!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa sách. Có thể sách đang được liên kết.");
	    }
	    return "redirect:/admin/sach";
	}
	
	
	@GetMapping("/category")
	public String getCategory(ModelMap model) {
		List<Catergory> catergories = categoryService.getAllCategory();
		model.addAttribute("categories", catergories);
		return "category/index";
	}
	
	@GetMapping("/tacgia")
	public String getAllAuthor(@RequestParam(name = "searchString", required = false) String search,
							   ModelMap model) {
		List<Author> authors = authorService.searchAuthors(search);
		for (Author author : authors) {
			author.setCountBook(bookAuthorService.countBooksByAuthor(author.getIdAuthor()));
		}
		model.addAttribute("authors",authors);
		return "author/index";
	}
	
	@GetMapping("/tacgia/detail/{id}")
	public String getAuthorDetail(@PathVariable Integer id,
								  ModelMap model) {
		Optional<Author> author = authorService.getAuthorById(id);
		List<Book> books = bookAuthorService.findBooksByAuthor(author.get());
		model.addAttribute("author",author.get());
		model.addAttribute("books",books);	
		return "author/detail";
	}
	
	@GetMapping("tacgia/edit/{id}")
	public String editAuthor(@PathVariable Integer id,
							 ModelMap model) {
		Optional<Author> author = authorService.getAuthorById(id);
		model.addAttribute("author",author.get());
		return "author/edit";
	}
	
	@PostMapping("/tacgia/edit")
	public String saveEditedAuthor(@ModelAttribute("author") Author author) {
	    authorService.saveAuthor(author);
	    return "redirect:/admin/tacgia"; // quay về danh sách tác giả
	}
	
	@GetMapping("/tacgia/create")
	public String getcreateAuthor(ModelMap model) {
		model.addAttribute("author", new Author());
		return "author/create";
	}
	
	@PostMapping("/tacgia/create")
	public String createAuthor(@ModelAttribute("author") Author author) {
	    authorService.saveAuthor(author);
	    return "redirect:/admin/tacgia";
	}
}
