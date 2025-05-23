package project.an.bookmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.models.BookAuthor;
import project.an.bookmanagement.repositories.AuthorRepository;
import project.an.bookmanagement.repositories.BookAuthorRepository;

@Service
public class BookAuthorService {
	@Autowired
	private BookAuthorRepository bookAuthorRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public void saveBookAuthors(Book book, List<Integer> authorIds) {
        List<BookAuthor> bookAuthors = new ArrayList<>();

        for (int i = 0; i < authorIds.size(); i++) {
            Integer authorId = authorIds.get(i);
            Author author = authorRepository.findById(authorId).orElse(null);
            if (author != null) {
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setBook(book);
                bookAuthor.setAuthor(author);
                bookAuthor.setMainAuthor(i == 0); // Gán tác giả đầu tiên là chính
                bookAuthors.add(bookAuthor);
            }
        }

        bookAuthorRepository.saveAll(bookAuthors);
    }
	
	@Transactional
	public void updateAuthorsForBook(Book book, List<Integer> authorIds) {

        bookAuthorRepository.deleteByBook(book);

        saveBookAuthors(book, authorIds);
    }
	
	public String getAuthorsStringByBook(Book book) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findByBook(book);

        return bookAuthors.stream()
                .map(bookAuthor -> bookAuthor.getAuthor().getAuthorName())
                .collect(Collectors.joining(", "));
    }
	
	public List<Author> findAuthorsByBook(Book book) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findByBook(book);
        return bookAuthors.stream()
                          .map(BookAuthor::getAuthor)
                          .collect(Collectors.toList());
    }
}
