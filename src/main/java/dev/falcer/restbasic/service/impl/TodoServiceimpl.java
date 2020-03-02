package dev.falcer.restbasic.service.impl;

import dev.falcer.restbasic.data.entity.Todo;
import dev.falcer.restbasic.data.repository.TodoRepository;
import dev.falcer.restbasic.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceimpl implements TodoService {
    @Autowired
    TodoRepository repos;

    @Override
    public List<Todo> getAll() {
        return repos.findAll();
    }

    @Override
    public Todo getById(Long id) {
        return repos.findById(id).orElse(null);
    }

    @Override
    public Todo create(Todo todo) {
        return repos.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        return repos.save(todo);
    }

    @Override
    public boolean delete(Long id) {
        Todo result = repos.findById(id).orElse(null);
        if(result != null){
            repos.deleteById(id);
            return true;
        }
        return false;
    }
}
