package dao;

import java.util.List;
import java.util.Optional;

import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import dao.infrastucture1.Repository;
import dao.infrastucture1.RepositoryImpl;
import model.Category;

public class CategoryRepositoryImpl extends RepositoryImpl<Long, Category> {

//public static void main(String[] args) throws EntityExistsException, EntityDoesNotExistException {
//	CategoryRepositoryImpl repo = (CategoryRepositoryImpl) new CategoryRepositoryImpl();
////	repo.add(new Category(0, "dsdf","dsd12","", null));
//	
//	for(Category p : repo.findAll()) {
//		System.out.println(p);
//	}
//	
//	System.out.println();
//	repo.update(new Category(null, null, null, null, null, null));
//	for(Category p : repo.findAll()) {
//		System.out.println(p);
//	}
//}

//	public void update(Category category);
//
//	public Category add(Category category);
//
//	public Optional<Category> findById(Long id);
//
//	public List<Category> findAll();

}
