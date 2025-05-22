package project.an.bookmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.an.bookmanagement.models.Catergory;
import project.an.bookmanagement.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Catergory> getAllCategory(){
		return categoryRepository.findAll();
	}
}
