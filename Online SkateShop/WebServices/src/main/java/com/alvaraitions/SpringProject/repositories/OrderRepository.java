package com.alvaraitions.SpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaraitions.SpringProject.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

	//Note: SpringJPA has already a standard implementation for this interface
	//Note: This class doesn't need annotation @Repository because it
	//inherits from JpaRepository
}
