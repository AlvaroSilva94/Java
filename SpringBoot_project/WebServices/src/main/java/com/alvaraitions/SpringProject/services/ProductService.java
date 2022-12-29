package com.alvaraitions.SpringProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaraitions.SpringProject.entities.Product;
import com.alvaraitions.SpringProject.repositories.ProductRepository;

//To register this class as a spring service to be automatically injected with autowired
@Service
public class ProductService
{
	//So that the dependency injection is transparent
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
