package util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import model.Category;
import model.Comment;
import model.Recipe;
import model.UsedProducts;
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

	public static void validateRecipe(Recipe p) {
		if (p.getComments().equals("") && p.getDescription().equals("")) {
			validateSimpleRecipe(p);
		} else {
			validateFullRecipe(p);
		}
	}

	private static Recipe validateSimpleRecipe(Recipe p) {
		validateSimpleRecipeData(p);
		return p;
	}

	private static Recipe validateFullRecipe(Recipe p) {
		validateSimpleRecipeData(p);
		checkValidString(p.getDescription(), ValidationPatterns.description,
				"Description should be between 20-2500 characters long");
		checkValidList(p.getComments(), ValidationPatterns.text);
		return p;
	}

	private static void validateSimpleRecipeData(Recipe p) {

		checkValidString(p.getTitle(), ValidationPatterns.title, "Invalid title!");
		checkValidString(p.getShortDescription(), ValidationPatterns.shortDescription, "Invalid shortDescription!");
		checkValidList(p.getUsedProducts(), ValidationPatterns.usedProducts, "Invalid usedproducts!");
	}

	private static void checkValidList(List<UsedProducts> usedProducts, String usedProducts2, String string) {
		if (!usedProducts.containsAll(usedProducts) || !usedProducts2.matches(ValidationPatterns.usedProducts)) {
			throw new IllegalArgumentException("Invalid usedProducts .");
		}

	}

	public static void checkValidList(List<Comment> comments, String invalidMsg) {
		if (comments != null && comments.size() != 0) {
			throw new IllegalArgumentException(invalidMsg);
		}
	}

	public static void validateComment(Comment p) {

		if (p.getUrl().equals("")) {
			validateSimpleComment(p);
		} else {
			validateFullComment(p);
		}
	}

	private static Comment validateSimpleComment(Comment p) {
		validateSimpleCommentData(p);
		return p;
	}

	private static Comment validateFullComment(Comment p) {
		validateSimpleCommentData(p);
		checkValidString(p.getUrl(), ValidationPatterns.url, "Description should be a valid url");

		return p;
	}

	private static void validateSimpleCommentData(Comment p) {

		checkValidString(p.getText(), ValidationPatterns.text, "Invalid text!");
		checkValidString(p.getUrl(), ValidationPatterns.url, "Invalid url!");

	}

	public static void validateCategory(Category p) {

		if (p.getDescription().equals("")) {
			validateSimpleCategory(p);
		} else {
			validateFullCategory(p);
		}
	}

	private static Category validateSimpleCategory(Category p) {
		validateSimpleCategoryData(p);
		return p;
	}

	private static Category validateFullCategory(Category p) {
		validateSimpleCategoryData(p);
		checkValidString(p.getDescription(), ValidationPatterns.description,
				"Description should be between 20-2500 characters long");

		return p;
	}

	private static void validateSimpleCategoryData(Category p) {

		checkValidString(p.getName(), ValidationPatterns.name, "Invalid title!");
		checkValidString(p.getDescription(), ValidationPatterns.description, "Invalid sDescription!");

	}

}
