package com.alvaraitions.SpringProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alvaraitions.SpringProject.entities.User;
import com.alvaraitions.SpringProject.repositories.UserRepository;
import com.alvaraitions.SpringProject.services.exceptions.DatabaseException;
import com.alvaraitions.SpringProject.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

//To register this class as a spring service to be automatically injected with autowired
@Service
public class UserService
{
	//So that the dependency injection is transparent
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //In case there is no User, throw exception
	}
	
	public User insert(User obj)
	{
		return repository.save(obj);
	}
	
	public void delete(Long id)
	{
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e)
		{
			//e.printStackTrace(); can be used just to see the type of the exception that was thrown
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id); //Only prepares the monitored object -> More efficient than find by id
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) 
		{
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		//Note: Doesn't make sense to allow password to be updated here
	}
}
