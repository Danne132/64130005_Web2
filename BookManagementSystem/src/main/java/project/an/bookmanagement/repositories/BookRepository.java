package project.an.bookmanagement.repositories;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.models.Catergory;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("SELECT COUNT(b) FROM Book b WHERE b.quantity < 50")
	long countByQuantityIsLessThan50();
	
	@Query("SELECT COUNT(b) FROM Book b WHERE b.quantity = 0")
	long countByQuantityEquals0();

	
	@Query("SELECT b FROM Book b WHERE LOWER(b.bookName) LIKE %:keyword% OR LOWER(b.category.categoryName) LIKE %:keyword%")
	Page<Book> searchByNameOrCategory(@Param("keyword") String keyword, Pageable pageable);
	
	int countByCategory(Catergory category);

	// Số lượng sách < 50
	Page<Book> findByQuantityBetween(int min, int max, Pageable pageable);

	// Số lượng = 0
	Page<Book> findByQuantity(int quantity, Pageable pageable);

	// Sắp xếp theo ngày cập nhật
	Page<Book> findAllByOrderByLastModified(Pageable pageable);
	
}
