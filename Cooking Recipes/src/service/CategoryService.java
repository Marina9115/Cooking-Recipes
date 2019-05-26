package service;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.Category;


public interface CategoryService {
	Category findById(long id) throws EntityDoesNotExistException;
	Collection<Category> findAll();
	Category add(Category entity) throws EntityExistsException, EntityDoesNotExistException ;
	Category update(Category entity) throws EntityDoesNotExistException;
	Category delete(long id) throws EntityDoesNotExistException;


}


