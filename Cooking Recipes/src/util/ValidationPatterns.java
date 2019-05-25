package util;

public class ValidationPatterns {

	// User
	public static String name = "^[A-Z]{1}[a-z]{1,14}$";
	public static String email = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static String username = "[A-Za-z]{2,15}";
	public static String password = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\*\\(\\)\\[\\]\\{\\}@!#$%^&+=])(?=\\S+$).{8,}$";
	public static String description = "^.{20,2500}$";
	public static String url = "\\b((http|https):\\/\\/?)[^\\s()<>]+(?:\\([\\w\\d]+\\)|([^[:punct:]\\s]|\\/?))";
	public static String metadata="^.{0,512}$";
	
	//Comments
	public static String text = ".{5,1500}";
	
	
	//Recipes
	public static String title="^.{2,120}$";
	public static String shortDescription="^.{2,250}$";
	public static String usedProducts="^.{20,500}$";

	//Category
	
	public static String nameCategory = "^{2,120}$";
	public static String descriptionCategory = "^{10,500}$";
}
