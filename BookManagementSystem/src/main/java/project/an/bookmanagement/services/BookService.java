package project.an.bookmanagement.services;

import java.util.List;

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
		return bookRepository.countBooksWithLowQuantity();
	}
	
	public Page<Book> searchBooks(String searchKeyword, int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("idBook").ascending());

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            return bookRepository.findAll(pageable);
        }

        return bookRepository.searchByBookNameOrCatergory(searchKeyword.trim(), pageable);
    }
}
