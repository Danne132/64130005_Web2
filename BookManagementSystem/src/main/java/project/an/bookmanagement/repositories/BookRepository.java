package project.an.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.an.bookmanagement.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("SELECT SUM(s.quantity) FROM book s")
    Integer sumSoLuongTonKho();
}
