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

//	public static <Role> List<Role> checkValidRoles(List<Role> inputRoles) {
//		Set<Role> roles = new HashSet(ArrayList.asList(Role.value()));
//		for (Role role : inputRoles) {
//			if (!roles.contains(role)) {
//				throw new IllegalArgumentException(String.format("Invalid role: %s", role));
//			}
//		}
//
//		return inputRoles;
//	}

	public static void validateRecipe(Recipe u) {

		// TODO Auto-generated method stub

	}

	public static void validateCategory(Category u) {
		// TODO Auto-generated method stub

	}

	public static void validateComment(Comment u) {
		// TODO Auto-generated method stub

	}

//	public static String getValidStringParam(String validationPattern, String inputMsg, String invalidInputMsg) {
//		System.out.print(inputMsg);
//		String input = Input.in.nextLine();
//
//		while (!input.matches(validationPattern)) {
//			System.out.println(invalidInputMsg);
//			System.out.print(inputMsg);
//			input = Input.in.nextLine();
//		}
//
//		return input;
//	}
//
//	public static String[] usernameAndPassword() {
//		String[] usernameAndPass = new String[2];
//		String usernameInputMsg = "Enter username: ";
//		String passwordInputMsg = "Enter password: ";
//		System.out.print(usernameInputMsg);
//		usernameAndPass[0] = Input.in.nextLine();
//		System.out.print(passwordInputMsg);
//		usernameAndPass[1] = Input.in.nextLine();
//
//		while (!usernameAndPass[0].matches(ValidationPatterns.username)
//				&& !usernameAndPass[1].matches(ValidationPatterns.password)) {
//			System.out.println("Invalid username or password!");
//
//			System.out.print(usernameInputMsg);
//			usernameAndPass[0] = Input.in.nextLine();
//			System.out.print(passwordInputMsg);
//			usernameAndPass[1] = Input.in.nextLine();
//		}
//
//		return usernameAndPass;
//	}
//
//	public static List<Role> getValidRoles(String inputMsg, String invalidInputMsg) {
//		List<Role> roles = new ArrayList<>();
//
//		while (roles.size() == 0) {
//			System.out.print(inputMsg);
//			String input = Input.in.nextLine();
//
//			List<String> inputElements = getAllInputMatchedElements(input);
//
//			for (String element : inputElements) {
//				addRole(roles, element, invalidInputMsg);
//			}
//		}
//
//		return roles;
//	}
//	
//	private static List<String> getAllInputMatchedElements(String input) {
//		List<String> allMatches = new ArrayList<>();
//		Matcher matches = Pattern.compile(ValidationPatterns.roleEnum).matcher(input);
//		while (matches.find()) {
//			allMatches.add(matches.group("role"));
//		}
//		
//		return allMatches;
//	}
//
//	private static void addRole(List<Role> roles, String role, String invalidRoleMsg) {
//		try {
//			Role r = Role.valueOf(Role.class, role.toUpperCase());
//			roles.add(r);
//		} catch (IllegalArgumentException e) {
//			System.err.println(invalidRoleMsg);
//		}
//	}
}
