package com.todoapp.controller;

import com.todoapp.model.Todo;
import com.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") // allow frontend
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return service.getTodoById(id);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTodo(id);
    }
}