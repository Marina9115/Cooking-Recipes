package service;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.CategoryRepository;
import dao.CategoryRepositoryImpl;
import dao.UserRepository;
import dao.UserRepositoryImpl;
import model.Category;
import model.Recipe;

public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository = new CategoryRepositoryImpl();
	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public Category findById(long id) throws EntityDoesNotExistException {

		return categoryRepository.findById(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find category with id: %d", id)));
	}

	@Override
	public Collection<Category> findAll() {

		return categoryRepository.findAll();
	}

	@Override
	public Category add(Category entity) throws EntityExistsException, EntityDoesNotExistException {
		Collection<Category> r = categoryRepository.findAll();
		long appearances = r.stream().filter(x->x.getName() == entity.getName()).count();
		if(appearances != 0) {
			throw new IllegalArgumentException("Category with the same name already exists");
		}			

		return categoryRepository.add(entity);
	}

	@Override
	public Category update(Category entity) throws EntityDoesNotExistException {

		Category category = findById(entity.getId());
		
		if(category == null) {
			throw new EntityDoesNotExistException("Cannot find such category");
		}
		return categoryRepository.update(entity);
	}

	@Override
	public Category delete(long id) throws EntityDoesNotExistException {

		return categoryRepository.delete(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find category with id: %d", id)));
	}

}
