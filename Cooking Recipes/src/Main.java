import java.util.ArrayList;

import controllers.UserController;
import cooking.exceptions.EntityDoesNotExistException;
import cooking.exceptions.EntityExistsException;
import model.AccountStatus;
import model.Comment;
import model.Gender;
import model.Recipe;
import model.Role;
import model.User;

public class Main {

	public static void main(String[] args) throws EntityDoesNotExistException, EntityExistsException {

		UserController userController = new UserController();
		User user = new User(1, "Ivan", "Ivanov", "ivan@gmail.com", "ivannnnnn", "Ivan1234!", Gender.MALE, Role.ADMIN,
				"", AccountStatus.ACTIVE, new ArrayList<Recipe>(), new ArrayList<Comment>());
		User user2 = new User(2, "Pesho", "Peshov", "ivan@gmail.com", "ivannnnnn", "Ivan1234!", Gender.MALE, Role.ADMIN,
				"", AccountStatus.ACTIVE, new ArrayList<Recipe>(), new ArrayList<Comment>());

		System.out.println(userController.add(user));
		System.out.println(userController.add(user2));
		System.out.println(userController.findAll());
		System.out.println(userController.findById(1));
		userController.findById(1).setFirstName("Test");
		
		System.out.println(userController.update(user));
		System.out.println(userController.delete(2));
		
		System.out.println();
		System.out.println(userController.findAll());
		
	}

}
