package project.an.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.an.bookmanagement.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
