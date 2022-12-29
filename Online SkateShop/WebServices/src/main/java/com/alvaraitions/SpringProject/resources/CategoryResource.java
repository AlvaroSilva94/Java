package com.alvaraitions.SpringProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaraitions.SpringProject.entities.Category;
import com.alvaraitions.SpringProject.services.CategoryService;

//Information to be implemented by RestController
@RestController
@RequestMapping(value = "/categories") //resource name
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	//Endpoint to access users -> rest controller that answer in path /users
	//GET type requisition
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); //responseEntity.ok means the request was successful
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
