package model;

import java.util.List;


public class Administrator extends User {

	private List<Category> categoriesModerated;

	public Administrator(Long id,String firstName, String lastName, String email, String username, String password,
			Gender gender, Role role, String picture, AccountStatus status, List<Recipe> recipes, List<Comment> comments) {
		super(id,firstName, lastName, email, username, password, gender, role, picture, status, recipes, comments);

	}

	public Administrator(long id,String firstName, String lastName, String email, String username, String password,
			Gender gender, Role role, String picture, String description, String metadata, AccountStatus status,
			List<Recipe> recipes, List<Comment> comments) {
		super(id,firstName, lastName, email, username, password, gender, role, picture, description, metadata, status,
				recipes, comments);

	}

	public List<Category> getCategoriesModerated() {
		return categoriesModerated;
	}

	public void setCategoriesModerated(List<Category> categoriesModerated) {
		this.categoriesModerated = categoriesModerated;
	}

	@Override
	public String toString() {
		return String.format("Administrator [categoriesModerated=%s]", categoriesModerated);
	}

}
