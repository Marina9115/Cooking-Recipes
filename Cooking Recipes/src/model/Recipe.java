package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.IdGenerator;
import dao.Identifiable;

public class Recipe implements Identifiable<Long> {
	private long id;
	private String category;
	private String title;
	private String author;
	private String shortDescription;
	private int cookingTime;
	private String picture;
	private String description;
	private List<String> tags;
	private LocalDate created = LocalDate.now();// created
	private LocalDate modified = LocalDate.now();// modified
	private List<Comment> comments;
	private List<UsedProducts> usedProducts;
	private List<User> users;

	public Recipe(String category, String title, String author, String shortDescription, int cookingTime,
			String picture, String description, List<String> tags,
			List<Comment> comments, List<UsedProducts> usedProducts, List<User> users) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
		this.shortDescription = shortDescription;
		this.cookingTime = cookingTime;
		this.picture = picture;
		this.description = description;
		this.tags = tags;
		this.comments = comments;
		this.usedProducts = usedProducts;
		this.users = users;
	}

	public Recipe(String category, String title, String author, String shortDescription, int cookingTime,
			String picture, List<String> tags , List<UsedProducts> usedProducts,
			List<User> users) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
		this.shortDescription = shortDescription;
		this.cookingTime = cookingTime;
		this.picture = picture;
		this.tags = tags;
		this.usedProducts = usedProducts;
		this.users = users;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getModified() {
		return modified;
	}

	public void setModified(LocalDate modified) {
		this.modified = modified;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<UsedProducts> getUsedProducts() {
		return usedProducts;
	}

	public void setUsedProducts(List<UsedProducts> usedProducts) {
		this.usedProducts = usedProducts;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
		
	}

	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String toString() {
		return String.format(
				"Recipe [id=%s, category=%s, title=%s, author=%s, shortDescription=%s, cookingTime=%s, picture=%s, description=%s, tags=%s, created=%s, modified=%s, comments=%s, usedProducts=%s, users=%s]",
				id, category, title, author, shortDescription, cookingTime, picture, description, tags, created,
				modified, comments, usedProducts, users);
	}
	

}
