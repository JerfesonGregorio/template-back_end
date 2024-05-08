package br.com.template.backend.controller;

import br.com.template.backend.dto.PermissaoPerfilRecursoDTO;
import br.com.template.backend.service.PermissaoPerfilRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/permissao-perfil-recurso")
@CrossOrigin
public class PermissaoPerfilRecurso {

    @Autowired
    PermissaoPerfilRecursoService permissaoPerfilRecursoService;

    @GetMapping
    public List<PermissaoPerfilRecursoDTO> listarTodos() {
        List<PermissaoPerfilRecursoDTO> permissaoPerfilRecursoDTOs;
        return permissaoPerfilRecursoDTOs = permissaoPerfilRecursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public PermissaoPerfilRecursoDTO buscarPorId(Long id) {
        PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO;
        return permissaoPerfilRecursoDTO = permissaoPerfilRecursoService.buscarPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
        permissaoPerfilRecursoService.inserir(permissaoPerfilRecurso);
    }

    @PutMapping
    public PermissaoPerfilRecursoDTO alterar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
        return permissaoPerfilRecursoService.alterar(permissaoPerfilRecurso);
    }

    @DeleteMapping
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        permissaoPerfilRecursoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
