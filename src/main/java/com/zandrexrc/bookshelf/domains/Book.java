package com.zandrexrc.bookshelf.domains;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class Book {
	
	@Id
	private String id;
	
	@NotBlank(message = "Title is mandatory")
	private String title;
	
	@NotEmpty(message = "Authors is mandatory")
	private List<String> authors;
	
	@NotBlank(message = "Status is mandatory")
	private String status;
	
	private String coverImage;
	
	// Getters
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	public String getCoverImage() {
		return coverImage;
	}
	
	public String getStatus() {
		return status;
	}
	
	// Setters
	public void setId(String id){
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}