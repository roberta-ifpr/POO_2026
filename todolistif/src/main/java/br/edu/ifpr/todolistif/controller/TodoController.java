package br.edu.ifpr.todolistif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifpr.todolistif.model.Todo;
import br.edu.ifpr.todolistif.repository.TodoRepository;

@Controller
public class TodoController {
    private final TodoRepository todoRepository;
    
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //criar uma nova tarefa
    @PostMapping("/create")
    public String create(Todo todo){
        todoRepository.save(todo);
        return "redirect:/";
    }

}
