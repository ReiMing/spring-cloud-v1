package com.springboot.websystem;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	public Todo() {
		
	}
	
	public Todo(int id, String description, LocalDate date, Boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.done = done;
	}
	
	@Id
	private int id;
	
	@Size(min=10,message="Enter atleast 10 characters")
	private String description;
	
	private LocalDate date;
	private Boolean done;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	
	
	
}
