package controllers;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.User;
import service.UserService;
import service.UserServiceImpl;
import util.InputValidator;

public class UserController {

	private UserService service = new UserServiceImpl();

	public User findById(long id) throws EntityDoesNotExistException {
		return service.findById(id);

	}

	public Collection<User> findAll() {
		return service.findAll();

	}

	public User add(User entity) throws EntityDoesNotExistException, EntityExistsException {
		InputValidator.validateUser(entity);
		return service.add(entity);

	}

	public User update(User entity) throws EntityDoesNotExistException {
		InputValidator.validateUser(entity);
		return service.update(entity);

	}

	public User delete(long id) throws EntityDoesNotExistException {
		return service.delete(id);
	}
}
