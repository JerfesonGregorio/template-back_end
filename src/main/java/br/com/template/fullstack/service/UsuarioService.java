package br.com.template.fullstack.service;

import br.com.template.fullstack.dto.UsuarioDto;
import br.com.template.fullstack.entity.UsuarioEntity;
import br.com.template.fullstack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }

    public UsuarioDto buscaPorId(Long id) {
        return new UsuarioDto(usuarioRepository.findById(id).get());
    }

    public void inserir(UsuarioDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioDto alterar(UsuarioDto usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDto(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

}
