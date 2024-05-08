package br.com.template.backend.repository;


import br.com.template.backend.entity.PerfilUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}
