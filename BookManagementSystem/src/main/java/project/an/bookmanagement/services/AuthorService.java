package project.an.bookmanagement.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import project.an.bookmanagement.models.Author;
import project.an.bookmanagement.models.Book;
import project.an.bookmanagement.repositories.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public long countAuthor() {
		return authorRepository.count();
	}
	
	public List<Author> getAllAuthor(){
		return authorRepository.findAll();
	}
	
	public List<Author> searchAuthors(String searchKeyword) {

        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            return authorRepository.searchByAuthorName(searchKeyword.toLowerCase());
        }
        return authorRepository.findAll();
	}
	
	public Optional<Author> getAuthorById(Integer Id){
		return authorRepository.findById(Id);
	}
	
	public Author findByName(String name) {
		return authorRepository.findByAuthorName(name);
	}
	
	public void saveAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public List<Author> findTop5AuthorsByBookCount() {
		List<Object[]> results = authorRepository.findTop5AuthorsByBookCount();
		List<Author> topAuthors = results.stream().map(row -> {
		    Author a = new Author();
		    a.setAuthorName((String) row[0]);
		    a.setCountBook(((Number) row[1]).longValue());
		    return a;
		}).collect(Collectors.toList());
		return topAuthors;
	}
}
