package com.myspringproject.springprj.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String logradouro;
    private String complemento;
    @Nonnull
    private String bairro;
    @Nonnull
    private String cidade;
    @Nonnull
    private String cep;
    @Nonnull
    private String uf;
    private String numero;
}
