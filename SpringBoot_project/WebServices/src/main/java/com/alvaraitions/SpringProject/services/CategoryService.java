package com.alvaraitions.SpringProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaraitions.SpringProject.entities.Category;
import com.alvaraitions.SpringProject.repositories.CategoryRepository;

//To register this class as a spring service to be automatically injected with autowired
@Service
public class CategoryService
{
	//So that the dependency injection is transparent
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
