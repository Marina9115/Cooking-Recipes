package controllers;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.Category;
import service.CategoryService;
import service.CategoryServiceImpl;
import util.InputValidator;


public class CategoryController {
	
	private CategoryService service = new CategoryServiceImpl();

	public Category findById(long id) throws EntityDoesNotExistException {
		return service.findById(id);
	}
		
		public Collection<Category> findAll() {
			return service.findAll();

		}

		public Category add(Category entity) throws EntityDoesNotExistException, EntityExistsException {
			InputValidator.validateCategory(entity);
			return service.add(entity);

		}

		public Category update(Category entity) throws EntityDoesNotExistException {
			InputValidator.validateCategory(entity);
			return service.update(entity);

		}

		public Category delete(long id) throws EntityDoesNotExistException {
			return service.delete(id);
		}
	
		

	}


