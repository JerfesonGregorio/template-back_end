package br.com.template.fullstack.controller;

import br.com.template.fullstack.dto.AuthDTO;
import br.com.template.fullstack.dto.UsuarioDTO;
import br.com.template.fullstack.service.AuthService;
import br.com.template.fullstack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(authService.login(authDTO));
    }

    @PostMapping(value = "/novo-usuario")
    public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario) {
        usuarioService.inserirNovoUsuario(novoUsuario);
    }

    @GetMapping(value = "/verificar-cadastro/{uuid}")
    public String verificarCadastro(@PathVariable("uuid") String uuid) {
        return usuarioService.verificarCadastro(uuid);
    }
}
