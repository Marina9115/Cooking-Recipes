package service;

import java.time.LocalDateTime;
import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.RecipeRepository;
import dao.RecipeRepositoryImpl;
import dao.UserRepository;
import dao.UserRepositoryImpl;
import model.Recipe;
import model.User;

public class RecipeServiceImpl implements RecipeService {
	private RecipeRepository recipeRepository = new RecipeRepositoryImpl();
	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public Recipe findById(long id) throws EntityDoesNotExistException {

		return recipeRepository.findById(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find recipe with id: %d", id)));
	}

	@Override
	public Collection<Recipe> findAll() {

		return recipeRepository.findAll();
	}

	@Override

	public Recipe add(Recipe entity) throws EntityExistsException, EntityDoesNotExistException {
		return null;
	}

	@Override
	public Recipe update(Recipe entity) throws EntityDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recipe delete(long id) throws EntityDoesNotExistException {
		return recipeRepository.delete(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find recipe with id: %d", id)));

	}
}
