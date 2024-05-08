package br.com.template.backend.service;

import br.com.template.backend.dto.PerfilUsuarioDTO;
import br.com.template.backend.entity.PerfilUsuarioEntity;
import br.com.template.backend.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    public List<PerfilUsuarioDTO> listarTodos() {
        List<PerfilUsuarioEntity> usuarios = perfilUsuarioRepository.findAll();
        return usuarios.stream().map(PerfilUsuarioDTO::new).toList();
    }

    public PerfilUsuarioDTO buscarPorId(Long id) {
        return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
    }

    public void inserir(PerfilUsuarioDTO perfilUsuario) {
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
        perfilUsuarioRepository.save(perfilUsuarioEntity);
    }

    public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuario) {
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
        return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
    }

    public void excluir(Long id) {
        PerfilUsuarioEntity usuarioPerfil = perfilUsuarioRepository.findById(id).get();
        perfilUsuarioRepository.delete(usuarioPerfil);
    }

}
