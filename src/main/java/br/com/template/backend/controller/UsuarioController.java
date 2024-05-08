package br.com.template.backend.controller;

import br.com.template.backend.dto.UsuarioDTO;
import br.com.template.backend.service.UsuarioService;
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
    public List<UsuarioDTO> listarTodos() {
        List<UsuarioDTO> usuarioDtos;
        usuarioDtos = usuarioService.listarTodos();
        return usuarioDtos;
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(Long id) {
        UsuarioDTO usuarioDto;
        usuarioDto = usuarioService.buscarPorId(id);
        return usuarioDto;
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuario) {
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuarioAlterado) {
        return usuarioService.alterar(usuarioAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
