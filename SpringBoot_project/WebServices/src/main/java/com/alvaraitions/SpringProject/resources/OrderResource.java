package com.alvaraitions.SpringProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaraitions.SpringProject.entities.Order;
import com.alvaraitions.SpringProject.services.OrderService;

//Information to be implemented by RestController
@RestController
@RequestMapping(value = "/orders") //resource name
public class OrderResource {

	@Autowired
	private OrderService service;
	
	//Endpoint to access Orders -> rest controller that answer in path /Orders
	//GET type requisition
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); //responseEntity.ok means the request was successful
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
