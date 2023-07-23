package com.springboot.websystem;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@RequestMapping("todo-lists")
	public String getTodoList(ModelMap map) {
		map.put("todos", todoService.getTodos());
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addTodo(ModelMap map) {
		Todo todo = new Todo(0,"", LocalDate.now(), false);
		map.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addTodo(ModelMap map,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			//map.put("todo", todo);
			return "addTodo";
		} else {
			todoService.addTodo(todo.getDescription());
			map.put("todos", todoService.getTodos());
			return "todo";
		}
	}
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(@RequestParam int id, ModelMap map) {
		todoService.deleteTodo(id);
		map.put("todos", todoService.getTodos());
		return "todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showupdateTodo(@RequestParam int id, ModelMap map) {
		Optional<Todo> result =todoService.getTodoById(id);
		if(!result.isEmpty()) {
			map.put("todo", result.get());
		} else {
			map.put("todo", new Todo());
		}
		
		return "updateTodo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap map,@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "updateTodo";
		} else {
			todoService.updateTodo(todo);
//			todoService.deleteTodo(todo.getId());
//			todoService.addTodo(todo.getDescription());
			
			map.put("todos", todoService.getTodos());
			return "todo";
		}
	}
}
