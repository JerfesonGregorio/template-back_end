package br.com.template.backend.repository;

import br.com.template.backend.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {

    public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
