package service;

import java.util.Collection;
import java.util.Optional;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.UserRepository;
import dao.UserRepositoryImpl;
import model.User;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public User findById(long id) throws EntityDoesNotExistException {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntityDoesNotExistException("Can't find user with id: " + id));
	}

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User add(User entity) throws EntityExistsException, EntityDoesNotExistException {
//		User user = findById(entity.getId());
//		if (user != null)
//			throw new EntityExistsException();
		return userRepository.add(entity);
	}

	@Override
	public User update(User entity) throws EntityDoesNotExistException {
		User user = findById(entity.getId());
		if (!user.getUsername().equals(entity.getUsername())) {
			throw new IllegalArgumentException("Cannot change username");
		}
		if (!user.getEmail().equals(entity.getEmail())) {
			throw new IllegalArgumentException("Cannot change email");
		}
		return userRepository.update(entity);
	}

	@Override
	public User delete(long id) throws EntityDoesNotExistException {
		return userRepository.delete(id)
				.orElseThrow(() -> new EntityDoesNotExistException("Can't find user with id: " + id));
	}

}
