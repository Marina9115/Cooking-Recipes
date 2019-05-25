package model;





import java.time.LocalDate;

import dao.Identifiable;

public class Comment implements Identifiable<Long>{
	
	private long id;
	private String author;
	private String recipe;
	private String text;
	private String url;
	private LocalDate created = LocalDate.now();//created
	private LocalDate modified=LocalDate.now();//modified
	public Comment(String author, String recipe, String text, String url) {
		super();
		this.author = author;
		this.recipe = recipe;
		this.text = text;
		this.url = url;
	}
	
	
	public Comment(String author, String recipe, String text) {
		super();
		this.author = author;
		this.recipe = recipe;
		this.text = text;
	}


	

	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getRecipe() {
		return recipe;
	}


	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
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


	@Override
	public String toString() {
		return String.format("Comment [id=%s, author=%s, recipe=%s, text=%s, url=%s, created=%s, modified=%s]", id,
				author, recipe, text, url, created, modified);
	}


	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}


	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id=id;
	}


	@Override
	public Long getNextId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	
	}






	
	
	
	
	
	


