package com.myspringproject.springprj.entity;

import com.myspringproject.springprj.dto.EnderecoDTO;
import com.myspringproject.springprj.dto.MedicoDTO;
import com.myspringproject.springprj.dto.MedicoResponseDTO;
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

    public MedicoEntity(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.crm = medicoDTO.crm();
        this.especialidade = medicoDTO.especialidade();
        this.endereco = toEndereco(medicoDTO.endereco());
    }
    private Endereco toEndereco(EnderecoDTO dto) {
        return new Endereco(
                dto.getLogradouro(),
                dto.getComplemento(),
                dto.getBairro(),
                dto.getCidade(),
                dto.getCep(),
                dto.getUf(),
                dto.getNumero()
        );
    }



    public MedicoEntity(MedicoResponseDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.crm = medicoDTO.crm();
        this.especialidade = medicoDTO.especialidade();

    }

    public void atualizarEndereco(EnderecoDTO dto) {
        if (dto.getLogradouro() != null) this.endereco.setLogradouro(dto.getLogradouro());
        if (dto.getBairro() != null) this.endereco.setBairro(dto.getBairro());
        if (dto.getCidade() != null) this.endereco.setCidade(dto.getCidade());
        if (dto.getUf() != null) this.endereco.setUf(dto.getUf());
        if (dto.getCep() != null) this.endereco.setCep(dto.getCep());
        if (dto.getNumero() != null) this.endereco.setNumero(dto.getNumero());
    }
}
