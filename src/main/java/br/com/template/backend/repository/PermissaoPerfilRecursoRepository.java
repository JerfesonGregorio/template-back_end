package br.com.template.backend.repository;

import br.com.template.backend.entity.PermissaoPerfilRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoPerfilRecursoRepository extends JpaRepository<PermissaoPerfilRecursoEntity, Long> {

}
