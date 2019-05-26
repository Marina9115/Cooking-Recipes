package service;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.Comment;


public interface CommentService {
	Comment findById(long id) throws EntityDoesNotExistException;
	Collection<Comment> findAll();
	Comment add(Comment entity) throws EntityExistsException, EntityDoesNotExistException ;
	Comment update (Comment entity) throws EntityDoesNotExistException;
	Comment delete(long id) throws EntityDoesNotExistException;

}
