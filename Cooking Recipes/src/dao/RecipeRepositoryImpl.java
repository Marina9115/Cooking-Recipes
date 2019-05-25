package dao;

import cooking.exceptions.EntityExistsException;
import dao.infrastucture1.RepositoryImpl;
import model.Category;
import model.Recipe;
import model.UsedProducts;
import model.User;

public class RecipeRepositoryImpl extends RepositoryImpl<Long, Recipe>{

private static int sequence = 0;
	
public RecipeRepositoryImpl() {
	super(() -> new Long(++sequence));
}

//	public static void main(String[] args) throws EntityExistsException {
//		UsedProducts s1 = new UsedProducts(1, "123", "brashno", 1.2, "frd");
//		Recipe inv1 = new Recipe();
//		User p1 = new User(sequence, "Marina", "Dibekova", "marina9109@abv.bg", "marina9109", null, null, null, null,
//				null, null, null, null);
//
//		RecipeRepositoryImpl recipeRepo = new RecipeRepositoryImpl();
//		recipeRepo.add(inv1);
//
//		for (Recipe i : recipeRepo.findAll()) {
//			System.out.println(i);
//		}

		
	}
	
	
	

