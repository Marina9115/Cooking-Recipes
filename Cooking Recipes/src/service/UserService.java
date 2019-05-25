package service;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.User;

public interface UserService {
	
	User findById(long id) throws EntityDoesNotExistException;
	Collection<User> findAll();
	User add(User entity) throws EntityExistsException, EntityDoesNotExistException ;
	User update(User entity) throws EntityDoesNotExistException;
	User delete(long id) throws EntityDoesNotExistException;

}
