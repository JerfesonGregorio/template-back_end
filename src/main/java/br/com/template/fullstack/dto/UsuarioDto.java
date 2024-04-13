package br.com.template.fullstack.dto;

import br.com.template.fullstack.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioDto {

    private long id;
    private String nome;
    private String login;
    private String email;
    private String senha;

    public UsuarioDto(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
