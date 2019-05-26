package service;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.CommentRepository;
import dao.CommentRepositoryImpl;
import dao.UserRepository;
import dao.UserRepositoryImpl;
import model.Comment;

public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository = new CommentRepositoryImpl();
	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public Comment findById(long id) throws EntityDoesNotExistException {
		return commentRepository.findById(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find comment with id: %d", id)));
	}

	@Override
	public Collection<Comment> findAll() {

		return commentRepository.findAll();
	}

	@Override
	public Comment add(Comment entity) throws EntityExistsException, EntityDoesNotExistException {
		Comment comment = findById(entity.getId());
//			if (comment != null)
//				throw new EntityExistsException()

		return commentRepository.add(entity);
	}

	@Override
	public Comment update(Comment entity) throws EntityDoesNotExistException {

		return commentRepository.update(entity);
	}

	@Override
	public Comment delete(long id) throws EntityDoesNotExistException {

		return commentRepository.delete(id).orElseThrow(
				() -> new EntityDoesNotExistException(String.format("Cannot find comment with id: %d", id)));
	}

}
