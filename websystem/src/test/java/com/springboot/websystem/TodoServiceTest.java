package com.springboot.websystem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class TodoServiceTest {

	@Test
	public void test( ) {
		List<Todo> list = new ArrayList<Todo>();
		list.add(new Todo(1,"",null,false));
		TodoService service = mock(TodoService.class);
		when(service.getTodos()).thenReturn(list);
		List<Todo> todo=service.getTodos();
		System.out.println(todo.size());
//		ResponseEntity.noContent()
		ResponseEntity<Todo> entity;
		
		String str =  """
				 <html>
				 	<body>Test text blocks</body>
				 </html>
				""";
		System.out.println(str);
	}
}
