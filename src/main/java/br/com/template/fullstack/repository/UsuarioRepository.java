package br.com.template.fullstack.repository;

import br.com.template.fullstack.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
