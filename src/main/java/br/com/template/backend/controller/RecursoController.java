package br.com.template.backend.controller;

import br.com.template.backend.dto.RecursoDTO;
import br.com.template.backend.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/recurso")
@CrossOrigin
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<RecursoDTO> listarTodos() {
        return recursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public RecursoDTO buscarPorId(Long id) {
        RecursoDTO recursoDTO;
        recursoDTO = recursoService.buscarPorId(id);
        return recursoDTO;
    }

    @PostMapping
    public void inserir(@RequestBody RecursoDTO recurso) {
        recursoService.inserir(recurso);
    }

    @PutMapping
    public RecursoDTO alterar(@RequestBody RecursoDTO recurso) {
        return recursoService.alterar(recurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        recursoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
