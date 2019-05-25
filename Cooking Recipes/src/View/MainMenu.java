package View;

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
import util.InputValidator;
import util.ValidationPatterns;

public class MainMenu {
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.start();
	}

	private void start() {
		while (true) {
			UserController controller = new UserController();

			System.out.println("---------------------------MENU----------------------------");
			System.out.println("COMMANDS: \n" + "\n" + "	ADD -> add new user\n"
					+ "	DELETE -> delete existing user\n" + "	UPDATE -> update existing user\n"
					+ "	FIND_BY_ID -> find user by id\n" + "	LIST_ALL -> list all users\n");
			System.out.print("Plese enter one of the commands above: ");

			String command = Input.readLine().toUpperCase();

			if (command.equals(MenuCommands.EXIT.toString())) {
				System.exit(0);
			} else if (command.equals(MenuCommands.ADD.toString())) {
				User user = readUser();
				try {
					System.out.println(controller.add(user));
				} catch (EntityDoesNotExistException | EntityExistsException e) {
					System.out.println(e.getMessage());
				}
			} else if (command.equals(MenuCommands.UPDATE.toString())) {
				long id = -1;
				while (true) {
					System.out.print("Enter user id:");
					try {
						id = Long.parseLong(Input.readLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Id should be number!");
					}
				}
				
				User user = null;
				try {
					user = controller.findById(id);
				} catch (EntityDoesNotExistException e) {
					System.out.println(e.getMessage());
				}
				
				user = readNewUser(user);
				try {
					controller.update(user);
				} catch (EntityDoesNotExistException e) {
					System.out.println(e.getMessage());
				}
				
				
			} else if (command.equals(MenuCommands.DELETE.toString())) {
				long id = -1;
				while (true) {
					System.out.print("Enter id of user you want to delete:");
					try {
						id = Long.parseLong(Input.readLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Id should be number!");
					}
				}

				try {
					System.out.println(controller.delete(id));
				} catch (EntityDoesNotExistException e) {
					System.out.println(e.getMessage());
				}

			} else if (command.equals(MenuCommands.FIND_BY_ID.toString())) {
				long id = -1;
				while (true) {
					System.out.print("Enter user id:");
					try {
						id = Long.parseLong(Input.readLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Id should be number!");
					}
				}

				try {
					System.out.println(controller.findById(id));
				} catch (EntityDoesNotExistException e) {
					System.out.println(e.getMessage());
				}
			} else if (command.equals(MenuCommands.FIND_ALL.toString())) {
				System.out.println(controller.findAll());
			}
		}

	}

	private User readUser() {
		long id = 0;
		while (true) {
			System.out.print("Enter id: ");
			try {
				id = Long.parseLong(Input.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}

		String firstName = "";
		while (true) {
			System.out.print("Enter first name: ");
			try {
				firstName = Input.readLine();
				InputValidator.checkValidString(firstName, ValidationPatterns.name, "invalid name");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}

		String lastName = "";
		while (true) {
			System.out.print("Enter last name: ");
			try {
				lastName = Input.readLine();
				InputValidator.checkValidString(lastName, ValidationPatterns.name, "invalid name");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		String email = "";
		while (true) {
			System.out.print("Enter email: ");
			try {
				email = Input.readLine();
				InputValidator.checkValidString(email, ValidationPatterns.email, "invalid email");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		String username = "";
		while (true) {
			System.out.print("Enter username: ");
			try {
				username = Input.readLine();
				InputValidator.checkValidString(username, ValidationPatterns.username, "invalid username");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		String password = "";
		while (true) {
			System.out.print("Enter password: ");
			try {
				password = Input.readLine();
				InputValidator.checkValidString(password, ValidationPatterns.password, "invalid password");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}

		Gender gender = null;
		while (true) {
			boolean isCorrect = true;
			System.out.print("Enter gender(M for male, F for female): ");
			String genderString = Input.readLine();
			switch (genderString) {
			case "M":
				gender = Gender.MALE;
				break;
			case "F":
				gender = Gender.FEMALE;
				break;
			default:
				isCorrect = false;
				break;
			}
			if (isCorrect) {
				break;
			}
		}

		String picture = "";
		while (true) {
			System.out.print("Enter picture: ");
			try {
				picture = Input.readLine();
				InputValidator.checkValidString(picture, ValidationPatterns.url, "invalid image url");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}

		// return new User(id, firstName, lastName, email, username, password, gender,
		// Role.HOME_COOK, picture, "", metadata, status, recipes, comments)
		return new User(id, firstName, lastName, email, username, password, gender, Role.HOME_COOK, picture,
				AccountStatus.ACTIVE, new ArrayList<Recipe>(), new ArrayList<Comment>());
	}
	
	private User readNewUser(User user) {
		
		String firstName = "";
		while (true) {
			System.out.print("Enter new first name: ");
			try {
				firstName = Input.readLine();
				InputValidator.checkValidString(firstName, ValidationPatterns.name, "invalid name");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		user.setFirstName(firstName);

		String lastName = "";
		while (true) {
			System.out.print("Enter new last name: ");
			try {
				lastName = Input.readLine();
				InputValidator.checkValidString(lastName, ValidationPatterns.name, "invalid name");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		user.setLastName(lastName);
		
		String password = "";
		while (true) {
			System.out.print("Enter new password: ");
			try {
				password = Input.readLine();
				InputValidator.checkValidString(password, ValidationPatterns.password, "invalid password");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		user.setPassword(password);

		Gender gender = null;
		while (true) {
			boolean isCorrect = true;
			System.out.print("Enter gender(M for male, F for female): ");
			String genderString = Input.readLine();
			switch (genderString) {
			case "M":
				gender = Gender.MALE;
				break;
			case "F":
				gender = Gender.FEMALE;
				break;
			default:
				isCorrect = false;
				break;
			}
			if (isCorrect) {
				break;
			}
		}
		user.setGender(gender);

		String picture = "";
		while (true) {
			System.out.print("Enter picture: ");
			try {
				picture = Input.readLine();
				InputValidator.checkValidString(picture, ValidationPatterns.url, "invalid image url");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		user.setPicture(picture);

		return user;
	}
}
