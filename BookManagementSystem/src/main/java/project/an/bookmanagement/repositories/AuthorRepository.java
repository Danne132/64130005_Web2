package project.an.bookmanagement.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	@Query("SELECT a FROM Author a WHERE " +
	           "LOWER(a.authorName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Author> searchByAuthorName(@Param("keyword") String keyword);
}
