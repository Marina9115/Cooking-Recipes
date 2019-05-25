package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import model.Category;
import model.Comment;
import model.Recipe;
import model.User;

public class InputValidator {

	public static void validateUser(User u) {
		if (u.getMetadata().equals("") && u.getDescription().equals("")) {
			validateSimpleUser(u);
		} else {
			validateFullUser(u);
		}
	}

	private static User validateSimpleUser(User u) {
		validateSimpleUserData(u);
		return u;
	}

	private static User validateFullUser(User u) {
		validateSimpleUserData(u);
		checkValidString(u.getDescription(), ValidationPatterns.description,
				"Description should be between 20-2500 characters long");
		checkValidString(u.getMetadata(), ValidationPatterns.metadata, "Metadata should be up to 512 characters long");
		return u;
	}

	private static void validateSimpleUserData(User u) {

		checkValidString(u.getFirstName(), ValidationPatterns.name, "Invalid name!");
		checkValidString(u.getLastName(), ValidationPatterns.name, "Invalid name!");
		checkValidString(u.getEmail(), ValidationPatterns.email, "Invalid email!");
		checkValidString(u.getPicture(), ValidationPatterns.url, "Invalid url!");
		checkValidUsernameAndPassword(u.getUsername(), u.getPassword());
	}

	public static void checkValidString(String param, String firstNamePattern, String invalidMsg) {
		if (!param.matches(firstNamePattern)) {
			throw new IllegalArgumentException(invalidMsg);
		}
	}

	private static void checkValidUsernameAndPassword(String username, String password) {
		if (!username.matches(username) || !password.matches(ValidationPatterns.password)) {
			throw new IllegalArgumentException("Invalid username or password.");
		}
	}

	public static void validateRecipe(Recipe entity) {
		// TODO Auto-generated method stub
		
	}

	public static void validateCategory(Category entity) {
		// TODO Auto-generated method stub
		
	}

	public static void validateComment(Comment entity) {
		// TODO Auto-generated method stub
		
	}
	
	

}
