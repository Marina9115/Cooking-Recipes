package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomeCooks<FavoriteCooks, FavoriteRecipes> extends User {

	private List<FavoriteCooks> favoriteCooks;
	private List<FavoriteRecipes> favoriteRecipes;

	public HomeCooks(Long id,String firstName, String lastName, String email, String username, String password,Gender gender,
			Role role, String picture, AccountStatus status, List<Recipe> recipes, List<Comment> comments) {
		super(id,firstName, lastName, email, username, password, gender, role, picture, status, recipes, comments);
		// TODO Auto-generated constructor stub
	}

	public HomeCooks(Long id,String firstName, String lastName, String email, String username, String password, Gender gender,
			Role role, String picture, String description, String metadata, AccountStatus status, List<Recipe> recipes,
			List<Comment> comments) {
		super(id,firstName, lastName, email, username, password, gender, role, picture, description, metadata, status,
				recipes, comments);
		// TODO Auto-generated constructor stub
	}

	public List<FavoriteCooks> getFavoriteCooks() {
		return favoriteCooks;
	}

	public void setFavoriteCooks(List<FavoriteCooks> favoriteCooks) {
		this.favoriteCooks = favoriteCooks;
	}

	public List<FavoriteRecipes> getFavoriteRecipes() {
		return favoriteRecipes;
	}

	public void setFavoriteRecipes(List<FavoriteRecipes> favoriteRecipes) {
		this.favoriteRecipes = favoriteRecipes;
	}

	@Override
	public String toString() {
		return String.format("HomeCooks [favoriteCooks=%s, favoriteRecipes=%s]", favoriteCooks, favoriteRecipes);
	}
	

}
