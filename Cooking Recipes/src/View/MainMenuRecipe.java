package View;

import java.util.ArrayList;
import java.util.InputMismatchException;

import controllers.RecipeController;
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

public class MainMenuRecipe {
	public static void main(String[] args) {
		MainMenuRecipe mainMenuRecipe = new MainMenuRecipe();
		mainMenuRecipe.start();
	}

	private void start() {
		while (true) {
			RecipeController controller = new RecipeController();

			System.out.println("---------------------------MENU----------------------------");
			System.out.println("COMMANDS: \n" + "\n" + "	ADD -> add new recipe\n"
					+ "	DELETE -> delete existing recipe\n" + "	UPDATE -> update existing recipe\n"
					+ "	FIND_BY_ID -> find recipe by id\n" + "	LIST_ALL -> list all recipes\n");
			System.out.print("Plese enter one of the commands above: ");

			String command = Input.readLine().toUpperCase();

			if (command.equals(MenuCommands.EXIT.toString())) {
				System.exit(0);
			} else if (command.equals(MenuCommands.ADD.toString())) {
				Recipe recipe = readRecipe();
				try {
					System.out.println(controller.add(recipe));
				} catch (EntityDoesNotExistException | EntityExistsException e) {
					System.out.println(e.getMessage());
				}
			} else if (command.equals(MenuCommands.UPDATE.toString())) {
				long id = -1;
				while (true) {
					System.out.print("Enter recipe id:");
					try {
						id = Long.parseLong(Input.readLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Id should be number!");
					}
				}

				Recipe recipe = null;
				try {
					recipe = controller.findById(id);
				} catch (EntityDoesNotExistException e) {
					System.out.println(e.getMessage());
				}

				recipe = readNewRecipe(recipe);
				try {
					controller.update(recipe);
				} catch (EntityDoesNotExistException e) {
					System.out.println(e.getMessage());
				}

			} else if (command.equals(MenuCommands.DELETE.toString())) {
				long id = -1;
				while (true) {
					System.out.print("Enter id of recipe you want to delete:");
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
					System.out.print("Enter recipe id:");
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

	private Recipe readRecipe() {
	long id = ;
	while (true) {
		System.out.print("Enter id: ");
		try {
			id = Long.parseLong(Input.readLine());
			break;
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	String category = "";
	while (true) {
		System.out.print("Enter category: ");
		try {
			category = Input.readLine();
			InputValidator.checkValidString(category, ValidationPatterns.nameCategory, "invalid category");
			break;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}

	String title = "";
	while (true) {
		System.out.print("Enter title: ");
		try {
			title = Input.readLine();
			InputValidator.checkValidString(title, ValidationPatterns.title, "invalid title");
			break;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}
	String autor = "";
	while (true) {
		System.out.print("Enter author: ");
		try {
			autor = Input.readLine();
			InputValidator.checkValidString(autor, ValidationPatterns.name, "invalid name");
			break;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}
	String shortDescription = "";
	while (true) {
		System.out.print("Enter shortDescription: ");
		try {
			shortDescription = Input.readLine();
			InputValidator.checkValidString(shortDescription, ValidationPatterns.shortDescription, "invalid shortDiscription");
			break;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}
	String description = "";
	while (true) {
		System.out.print("Enter desciption: ");
		try {
			description = Input.readLine();
			InputValidator.checkValidString(description, ValidationPatterns.description, "invalid desciption");
			break;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

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
			
			 String cookingTime = "";
			 try {
			   int x = Integer.parseInt(cookingTime); 
			   // You can use this method to convert String to int, But if input 
			   //is not an int  value then this will throws NumberFormatException. 
			   System.out.println("Valid cookingTime");
			 }catch(NumberFormatException e1) {
		   System.out.println("cookingTime is not an int value"); 
			 }
		}
	}
			 
			   // Here catch NumberFormatException

	// return new User(id, firstName, lastName, email, username, password, gender,
	// Role.HOME_COOK, picture, "", metadata, status, recipes, comments)
//
	//		 return new Recipe(category, title, autor, shortDescription, cookingTime, picture, description, new ArrayList<String>(), new ArrayList<User>(), new ArrayList<Comment>());

	}
	private Recipe readNewRecipe(Recipe recipe) {
		String category = "";
		while (true) {
			System.out.print("Enter category: ");
			try {
				category = Input.readLine();
				InputValidator.checkValidString(category, ValidationPatterns.nameCategory, "invalid category");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		recipe.setCategory(category);
		String title = "";
		while (true) {
			System.out.print("Enter title: ");
			try {
				title = Input.readLine();
				InputValidator.checkValidString(title, ValidationPatterns.title, "invalid title");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		recipe.setTitle(title);
		String autor = "";
		while (true) {
			System.out.print("Enter author: ");
			try {
				autor = Input.readLine();
				InputValidator.checkValidString(autor, ValidationPatterns.name, "invalid name");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		recipe.setAuthor(autor);
		String shortDescription = "";
		while (true) {
			System.out.print("Enter shortDescription: ");
			try {
				shortDescription = Input.readLine();
				InputValidator.checkValidString(shortDescription, ValidationPatterns.shortDescription,
						"invalid shortDiscription");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		recipe.setShortDescription(shortDescription);
		String description = "";
		while (true) {
			System.out.print("Enter desciption: ");
			try {
				description = Input.readLine();
				InputValidator.checkValidString(description, ValidationPatterns.description, "invalid desciption");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}
		}
		recipe.setDescription(description);

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
		recipe.setPicture(picture);
		return recipe;

	}

}
