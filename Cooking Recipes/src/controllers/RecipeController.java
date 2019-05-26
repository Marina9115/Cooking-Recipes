package controllers;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.Recipe;
import model.User;
import service.RecipeService;
import service.RecipeServiceImpl;
import util.InputValidator;


public class RecipeController {
	private RecipeService service = new RecipeServiceImpl();

	public Recipe findById(long id) throws EntityDoesNotExistException {
		 return service.findById(id);

	}
	
	public Collection<Recipe> findAll() {
		return service.findAll();
	}
		
		
		public Recipe add(Recipe entity) throws EntityDoesNotExistException, EntityExistsException {
			InputValidator.validateRecipe(entity);
			return service.add(entity);

		}

		public Recipe update(Recipe entity) throws EntityDoesNotExistException {
			InputValidator.validateRecipe(entity);
			return service.update(entity);

		}

		public Recipe delete(long id) throws EntityDoesNotExistException {
			return service.delete(id);
		
	}
	
	}


