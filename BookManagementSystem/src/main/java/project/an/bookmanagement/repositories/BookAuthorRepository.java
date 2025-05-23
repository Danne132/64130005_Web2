package project.an.bookmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.models.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer>{
	List<BookAuthor> findByBook(Book book);
	void deleteByBook(Book book);
	List<BookAuthor> findByAuthor(Author author);
    @Query("SELECT COUNT(DISTINCT ba.book.idBook) FROM BookAuthor ba WHERE ba.author.idAuthor = :authorId")
    long countBooksByAuthorId(@Param("authorId") Integer authorId);
}
