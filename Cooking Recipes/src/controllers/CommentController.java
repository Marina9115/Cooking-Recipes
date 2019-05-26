package controllers;

import java.util.Collection;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.Comment;
import service.CommentService;
import service.CommentServiceImpl;
import util.InputValidator;

public class CommentController {
	private CommentService service = new CommentServiceImpl();
	
	public Comment findById(long id) throws EntityDoesNotExistException {
		 return service.findById(id);

	}
	
	public Collection<Comment> findAll() {
		return service.findAll();
	}
		
		
		public Comment add(Comment entity) throws EntityDoesNotExistException, EntityExistsException {
			InputValidator.validateComment(entity);
			return service.add(entity);

		}

		public Comment update(Comment entity) throws EntityDoesNotExistException {
			InputValidator.validateComment(entity);
			return service.update(entity);

		}

		public Comment delete(long id) throws EntityDoesNotExistException {
			return service.delete(id);
		
	}
	
	}
	



