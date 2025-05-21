package project.an.bookmanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.an.bookmanagement.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("SELECT COUNT(b) FROM Book b WHERE b.quantity < 50")
	long countBooksWithLowQuantity();
	
	@Query("SELECT b FROM Book b WHERE " +
	           "LOWER(b.bookName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
	           "OR LOWER(b.category.categoryName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	Page<Book> searchByBookNameOrCatergory(@Param("keyword") String keyword, Pageable pageable);
	
}
