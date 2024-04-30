package br.com.template.fullstack.entity;

import br.com.template.fullstack.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PERMISSAO_PERFIL_RECURSO")
public class PermissaoPerfilRecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "ID_RECURSO")
    private RecursoEntity recurso;

    public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {

        BeanUtils.copyProperties(permissaoPerfilRecurso, this);

        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilEntity(permissaoPerfilRecurso.getPerfil());
        }

        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso = new RecursoEntity(permissaoPerfilRecurso.getRecurso());
        }

    }

}
