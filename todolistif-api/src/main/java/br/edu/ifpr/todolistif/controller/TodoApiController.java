package br.edu.ifpr.todolistif.controller;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.ifpr.todolistif.dto.*;
import br.edu.ifpr.todolistif.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    private final TodoService service;
    public TodoApiController(TodoService service) { this.service = service; }
    @GetMapping
    public List<TodoRespostaDTO> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public TodoRespostaDTO buscar(@PathVariable("id") Long id) { return service.buscar(id); }
    @PostMapping
    public ResponseEntity<TodoRespostaDTO> cadastrar(@RequestBody TodoEntradaDTO dados) {
        TodoRespostaDTO resposta = service.cadastrar(dados);
        return ResponseEntity.created(URI.create("/api/todos/" + resposta.getId())).body(resposta);
    }
    @PutMapping("/{id}")
    public TodoRespostaDTO atualizar(@PathVariable("id") Long id, @RequestBody TodoEntradaDTO dados) {
        return service.atualizar(id, dados);
    }
    // Operação específica para a conclusão. Não exige corpo.
    @PatchMapping("/{id}/conclusao")
    public TodoRespostaDTO concluir(@PathVariable("id") Long id) { return service.concluir(id); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
