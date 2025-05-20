package project.an.bookmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.an.bookmanagement.repositories.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public long countAuthor() {
		return authorRepository.count();
	}
}
