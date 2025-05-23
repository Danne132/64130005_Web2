package project.an.bookmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public long countBookInStore() {
		return bookRepository.count();
	}
	
	public long CountBookFewer() {
		return bookRepository.countByQuantityIsLessThan50();
	}
	
	public long CountBookOutStock() {
		return bookRepository.countByQuantityEquals0();
	}
	
	public Page<Book> searchBooks(String searchKeyword, int page, String sort) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("bookName").ascending());

        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            return bookRepository.searchByNameOrCategory(searchKeyword.toLowerCase(), pageable);
        } else {
            switch (sort != null ? sort : "") {
                case "pre-sold":
                    return bookRepository.findByQuantityBetween(1, 49, pageable);
                case "sold":
                    return bookRepository.findByQuantity(0, pageable);
                case "now":
                    return bookRepository.findAllByOrderByLastModified(pageable);
                default:
                    return bookRepository.findAll(pageable);
            }
        }
    }
	
	public Book SaveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> findBookById(Integer id) {
		return bookRepository.findById(id);
	}
}
