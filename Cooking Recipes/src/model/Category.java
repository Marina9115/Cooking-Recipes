package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.Identifiable;

public class Category implements Identifiable<Long> {

	private long id;
	private String name;
	private String description;
	private List<String> tags;
	private LocalDate created = LocalDate.now();// created
	private LocalDate modifeid = LocalDate.now();// modified
	private List<Recipe> recipes;

	public Category(String name, String description, List<String> tags, List<Recipe> recipes) {
		super();
		this.name = name;
		this.description = description;
		this.tags = tags;
		this.recipes = recipes;
	}

	public Category(String name, List<String> tags, List<Recipe> recipes) {
		super();
		this.name = name;
		this.tags = tags;
		this.recipes = recipes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDate getModifeid() {
		return modifeid;
	}

	public void setModifeid(LocalDate modifeid) {
		this.modifeid = modifeid;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return String.format("Category [id=%s, name=%s, description=%s, tags=%s, created=%s, modifeid=%s, recipes=%s]",
				id, name, description, tags, created, modifeid, recipes);
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

}
