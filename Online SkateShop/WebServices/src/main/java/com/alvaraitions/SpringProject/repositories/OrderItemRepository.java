package com.alvaraitions.SpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaraitions.SpringProject.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

	//Note: SpringJPA has already a standard implementation for this interface
	//Note: This class doesn't need annotation @Repository because it
	//inherits from JpaRepository
}
