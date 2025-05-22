package project.an.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.an.bookmanagement.models.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer>{

}
