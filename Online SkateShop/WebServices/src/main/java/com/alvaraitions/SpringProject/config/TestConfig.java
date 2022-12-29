package com.alvaraitions.SpringProject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alvaraitions.SpringProject.entities.Category;
import com.alvaraitions.SpringProject.entities.Order;
import com.alvaraitions.SpringProject.entities.OrderItem;
import com.alvaraitions.SpringProject.entities.Payment;
import com.alvaraitions.SpringProject.entities.Product;
import com.alvaraitions.SpringProject.entities.User;
import com.alvaraitions.SpringProject.entities.enums.OrderStatus;
import com.alvaraitions.SpringProject.repositories.CategoryRepository;
import com.alvaraitions.SpringProject.repositories.OrderItemRepository;
import com.alvaraitions.SpringProject.repositories.OrderRepository;
import com.alvaraitions.SpringProject.repositories.ProductRepository;
import com.alvaraitions.SpringProject.repositories.UserRepository;

//So Spring knows that this is a configuration class for the test profile
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//Note: Database seeding = populate database with objects
	//This annotation is for spring to resolve the dependency and associate and instance of
	// user repository in here
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Boards");
		Category cat2 = new Category(null, "Wheels");
		Category cat3 = new Category(null, "Trucks");
		Category cat4 = new Category(null, "Bushings");
		Category cat5 = new Category(null, "Griptape and Hardware");
		
		Product p1 = new Product(null, "Toy machine 8.25 deck", "Medium concave", 90.5, "");
		Product p2 = new Product(null, "Spitfire Formula 4 52mm 99a", "Great wheels", 59.0, "");
		Product p3 = new Product(null, "Tensor Mag Lights 149 pro", "Lighter trucks than normal", 125.0, "");
		Product p4 = new Product(null, "Bones bushings 91a", "Hardness: hard", 12.0, "");
		Product p5 = new Product(null, "Basic griptape", "Color: black", 1.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3, cat4, cat5));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		//Association between objects
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null,"New Skater","newSk8@gmail.com", "99999999", "123456");
		User u2 = new User(null,"Old Skater", "oldSk8@gmail.com", "99988888", "123456");
	
		Order o1 = new Order(null,Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null,Instant.parse("2021-07-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null,Instant.parse("2020-08-20T19:53:07Z"), OrderStatus.SHIPPED, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2022-06-20T21:53:07Z"),o1);
		
		//To save a payment, due to the oneToOne relationship, we don't do paymentRepository.saveAll(...)
		// we use the independent class in which payment is dependent on and save that one instead
		o1.setPayment(pay1);
		orderRepository.save(o1);
		
	}
	
	//Class To execute when program starts
	
}
