package br.com.template.fullstack.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

    private String token;

    //TODO implementar retornar o usuario e liberações (authorities)

    public AcessDTO(String token) {
        super();
        this.token = token;
    }

}
