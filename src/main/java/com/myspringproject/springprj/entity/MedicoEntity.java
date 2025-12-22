package com.myspringproject.springprj.entity;

import com.myspringproject.springprj.dto.EnderecoDTO;
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


    public void atualizarEndereco(EnderecoDTO dto) {
        if (dto.logradouro() != null) this.endereco.setLogradouro(dto.logradouro());
        if (dto.bairro() != null) this.endereco.setBairro(dto.bairro());
        if (dto.cidade() != null) this.endereco.setCidade(dto.cidade());
        if (dto.uf() != null) this.endereco.setUf(dto.uf());
        if (dto.cep() != null) this.endereco.setCep(dto.cep());
        if (dto.numero() != null) this.endereco.setNumero(dto.numero());
    }
}
