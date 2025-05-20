package project.an.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.an.bookmanagement.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("SELECT COUNT(b) FROM Book b WHERE b.quantity < 50")
	long countBooksWithLowQuantity();
	
}
