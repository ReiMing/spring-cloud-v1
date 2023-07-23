package com.springboot.websystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	public TodoService() {
		
	}
	
	public TodoService(TodoRepository todoRepository) {
		super();
	}

//	static List<Todo> todos = new ArrayList<Todo>();
//	static int count=0;
//	static {
//		todos.add(new Todo(++count,"learn aws", LocalDate.now(), false));
//		todos.add(new Todo(++count,"learn devops", LocalDate.now(), false));
//		todos.add(new Todo(++count,"learn springboot", LocalDate.now(), false));
//	}
//	
	
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}
	public Todo getTodoByDescription(String description) {
		return todoRepository.findByDescription(description);
	}
	
	public Optional<Todo> getTodoById(int id) {
		return todoRepository.findById(id);
	}
	
	public List<Todo> getTodos(){
		return todoRepository.findAll();
	}
	
	public void addTodo(String description ) {
		int count=(int) todoRepository.count();
		todoRepository.save(new Todo(++count,description,LocalDate.now(), false));
		
	}
	
	public void deleteTodo(int id) {
		todoRepository.deleteById(id);
		//todos.removeIf(t -> t.getId() ==id);
	}
}
