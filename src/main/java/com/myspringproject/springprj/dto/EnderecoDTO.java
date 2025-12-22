package com.myspringproject.springprj.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String numero;

}
