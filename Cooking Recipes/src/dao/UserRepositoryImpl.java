package dao;

import dao.infrastucture1.RepositoryImpl;
import model.User;

public class UserRepositoryImpl  extends  RepositoryImpl<Long,User> implements UserRepository{
	
private static int sequence = 0;
	
	public UserRepositoryImpl() {
		super(() -> new Long(++sequence));
	}

//	public static void main(String[] args) throws EntityExistsException, EntityDoesNotExistException {
//		UserRepositoryImpl repo = new UserRepositoryImpl();
//		repo.add( new User(sequence, "Marinq", "Dibekova","marina9109@abv.bg", "marina9109", null, null, null, null, null, null, null, null));
//		
//		for(User p: repo.findAll()) {
//			System.out.println(p);
//		}
//		
//		System.out.println();
//		repo.update( new User(sequence, "Marinq", "Dibekova","marina9109@abv.bg", "marina9109", null, null, null, null, null, null, null, null));
//		for(User p:repo.findAll()) {
//			System.out.println(p);
//		}
	}
		


	

	
 


