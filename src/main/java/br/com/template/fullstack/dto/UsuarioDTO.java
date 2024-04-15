package br.com.template.fullstack.dto;

import br.com.template.fullstack.entity.UsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private long id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

}
