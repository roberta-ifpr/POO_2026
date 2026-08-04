package br.edu.ifpr.todolistif.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifpr.todolistif.model.Todo;
import br.edu.ifpr.todolistif.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // criar uma nova tarefa
    @PostMapping("/create")
    public String create(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    /*
     * @GetMapping("/")
     * public String index() {
     * return "index";
     * }
     */

    @GetMapping("/")
    public ModelAndView list() { // ModelAndView cria uma visao do modelo, como quero mostrar a saída
        return new ModelAndView(
                "index", Map.of("todos", todoRepository.findAll()));
    }

    @GetMapping("/teste/todos") // pra testar no thunder
    @ResponseBody
    public List<Todo> listJson() {
        return todoRepository.findAll();
    }

}
