package project.an.bookmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.an.bookmanagement.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public int countBookInStore() {
		return bookRepository.sumSoLuongTonKho();
	}
}
