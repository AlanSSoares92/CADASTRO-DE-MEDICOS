package com.myspringproject.springprj.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_medico")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String nome;
    @Nonnull
    private String email;
    @Nonnull
    private String telefone;
    @Nonnull
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


}
