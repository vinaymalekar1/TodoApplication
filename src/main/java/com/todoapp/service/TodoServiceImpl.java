package com.todoapp.service.impl;

import com.todoapp.model.Todo;
import com.todoapp.repository.TodoRepository;
import com.todoapp.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repo;

    public TodoServiceImpl(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Todo createTodo(Todo todo) {
        return repo.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo existing = getTodoById(id);
        existing.setTitle(todo.getTitle());
        existing.setDescription(todo.getDescription());
        existing.setCompleted(todo.isCompleted());
        return repo.save(existing);
    }

    @Override
    public void deleteTodo(Long id) {
        repo.deleteById(id);
    }
}
