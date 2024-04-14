package br.com.template.fullstack.repository;

import br.com.template.fullstack.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
