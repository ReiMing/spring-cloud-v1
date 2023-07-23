package com.springboot.websystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  TodoRepository extends JpaRepository<Todo, Integer>{

	public Todo findByDescription(String Description);
}
