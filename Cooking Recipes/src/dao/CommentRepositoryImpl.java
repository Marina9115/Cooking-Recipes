package dao;

import java.util.Collection;
import java.util.Optional;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.infrastucture1.RepositoryImpl;
import model.Comment;

public class CommentRepositoryImpl extends RepositoryImpl<Long, Comment> 
implements CommentRepository{
	
	
//public static void main(String[] args) throws EntityExistsException, EntityDoesNotExistException {
//	CommentRepository repo = new CommentRepositoryImpl();
//	repo.add(new Comment("fsdfd", "gddf", "rrdsfsdsd", "dsfds", "11232", "4343"));
//	
//	for(Comment p : repo.findAll()) {
//		System.out.println(p);
//	}
//	
//	System.out.println();
//	repo.update(new Comment(0, "82122423412", "dsfdf", "mnogo hubava resepta", null, null, null));
//	for(Comment p : repo.findAll()) {
//		System.out.println(p);
//	} 
//	
//}

}


