package com.alvaraitions.SpringProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaraitions.SpringProject.entities.Order;
import com.alvaraitions.SpringProject.repositories.OrderRepository;

//To register this class as a spring service to be automatically injected with autowired
@Service
public class OrderService
{
	//So that the dependency injection is transparent
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
