package br.com.template.fullstack.controller;

import br.com.template.fullstack.dto.UsuarioDto;
import br.com.template.fullstack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> listarTodos() {
        List<UsuarioDto> usuarioDtos;
        usuarioDtos = usuarioService.listarTodos();
        return usuarioDtos;
    }

    @GetMapping("/{id}")
    public UsuarioDto buscarPorId(Long id) {
        UsuarioDto usuarioDto;
        usuarioDto = usuarioService.buscarPorId(id);
        return usuarioDto;
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDto usuario) {
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDto alterar(@RequestBody UsuarioDto usuarioAlterado) {
        return usuarioService.alterar(usuarioAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
