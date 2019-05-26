package service;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.Recipe;


public interface RecipeService {
	Recipe findById(long id) throws EntityDoesNotExistException;
	Collection<Recipe> findAll();
	Recipe add(Recipe entity) throws EntityExistsException, EntityDoesNotExistException ;
	Recipe update(Recipe entity) throws EntityDoesNotExistException;
	Recipe delete(long id) throws EntityDoesNotExistException;


}
