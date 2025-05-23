package project.an.bookmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.models.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer>{
	List<BookAuthor> findByBook(Book book);
	void deleteByBook(Book book);
}
