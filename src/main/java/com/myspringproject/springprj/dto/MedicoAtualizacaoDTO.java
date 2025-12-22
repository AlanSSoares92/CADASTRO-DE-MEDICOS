package com.myspringproject.springprj.dto;

public record MedicoAtualizacaoDTO(Long id,
                                   String nome,
                                   String telefone,
                                   EnderecoDTO endereco) {
}
