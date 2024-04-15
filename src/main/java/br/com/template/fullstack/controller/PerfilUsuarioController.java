package br.com.template.fullstack.controller;

import br.com.template.fullstack.dto.PerfilUsuarioDTO;
import br.com.template.fullstack.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public List<PerfilUsuarioDTO> listarTodos() {
        List<PerfilUsuarioDTO> perfilUsuarioDTOs;
        perfilUsuarioDTOs = perfilUsuarioService.listarTodos();
        return perfilUsuarioDTOs;
    }

    @GetMapping("/{id}")
    public PerfilUsuarioDTO buscarPorId(Long id) {
        PerfilUsuarioDTO perfilUsuarioDto;
        perfilUsuarioDto = perfilUsuarioService.buscarPorId(id);
        return perfilUsuarioDto;
    }

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfilUsuario) {
        perfilUsuarioService.inserir(perfilUsuario);
    }

    @PutMapping
    public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfilUsuarioAlterado) {
        return perfilUsuarioService.alterar(perfilUsuarioAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        perfilUsuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
