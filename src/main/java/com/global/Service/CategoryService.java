package com.global.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Category;
import com.global.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories(){
		
		return categoryRepository.findAll();
	}
	
	public Optional<Category> grtCatById(Integer id) {
		
		return categoryRepository.findById(id);
	}
	
	public void addCategory(Category category) {
		
		categoryRepository.save(category);
	}
	
	
	public void deleteCat(int id) {
		
		categoryRepository.deleteById((int) id);
		
	}
	
	
	
	
	
}
