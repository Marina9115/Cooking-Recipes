package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.RoleStatus;

import dao.Identifiable;

public class User implements Identifiable<Long> {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Gender gender;
	private Role role;
	private String picture;
	private String description;
	private String metadata;
	private AccountStatus status;
	private LocalDateTime created;
	private LocalDateTime modified;

	private List<Recipe> recipes;
	private List<Comment> comments;

	public User(long id, String firstName, String lastName, String email, String username, String password,
			Gender gender, Role role, String picture, AccountStatus status, List<Recipe> recipes,
			List<Comment> comments) {

		this(id, firstName, lastName, email, username, password, gender, role, picture, "", "", status, recipes,
				comments);
	}

	public User(long id, String firstName, String lastName, String email, String username, String password,
			Gender gender, Role role, String picture, String description, String metadata, AccountStatus status,
			List<Recipe> recipes, List<Comment> comments) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.picture = picture;
		this.description = description;
		this.metadata = metadata;
		this.status = status;
		this.recipes = recipes;
		this.comments = comments;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public Long getNextId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}
	
	
	public String printHeader() {
		return String.format(
				"| U:  %12s | %12.12s | %12.12s | %15.15s | %12.12s | %12.12s | %12.12s | %12.12s | %16.16s | %16.16s | %16.16s |",
				"ID", "First Name", "Last Name", "Email", "Username", "Password", "Roles", "Gender", "Status",
				"Created", "Modified");
	}

	@Override
	public String toString() {
		String createdString = created.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		String modifiedString = modified.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		return String.format(
				"| U:  %012d | %12.12s | %12.12s | %15.15s | %12.12s | %12.12s | %12.12s | %12.12s | %16.16s | %16.16s | %16.16s |",
				id, firstName, lastName, email, username, password, role, gender, status, createdString,
				modifiedString);
	}

	
	private String hidePassString() {
		StringBuilder pass = new StringBuilder();
		for (int i = 0; i < password.length(); i++) {
			pass.append("*");
		}
		return pass.toString();
	}

	
	}


	
	

