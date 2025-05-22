package project.an.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.an.bookmanagement.models.Catergory;

public interface CategoryRepository extends JpaRepository<Catergory, Integer>{

}
