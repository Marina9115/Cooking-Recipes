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

		Category category = findById(entity.getId());
//			if (category != null)
//				throw new EntityExistsException()

		return categoryRepository.add(entity);
	}

	@Override
	public Category update(Category entity) throws EntityDoesNotExistException {

		Category category = findById(entity.getId());
//			if (!category.getName().equals(entity.getName())) {
//				throw new IllegalArgumentException("Cannot change name");
//			}
//			if (!category.getRecipes().equals(entity.getRecipes())) {
//				throw new IllegalArgumentException("Cannot change recipe");
//			}
//			
		return categoryRepository.update(entity);
	}

	@Override
	public Category delete(long id) throws EntityDoesNotExistException {

		return categoryRepository.delete(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find category with id: %d", id)));
	}

}
