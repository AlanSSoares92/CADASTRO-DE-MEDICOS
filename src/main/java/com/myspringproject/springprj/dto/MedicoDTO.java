package com.myspringproject.springprj.dto;

import com.myspringproject.springprj.entity.Especialidade;

public record MedicoDTO(String nome, String email, String telefone, String crm, Especialidade especialidade, EnderecoDTO endereco, boolean ativo) {

}
