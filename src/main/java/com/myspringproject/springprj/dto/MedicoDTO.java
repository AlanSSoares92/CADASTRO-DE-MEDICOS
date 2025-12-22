package com.myspringproject.springprj.dto;

import com.myspringproject.springprj.entity.Especialidade;
import com.myspringproject.springprj.entity.MedicoEntity;

public record MedicoDTO(String nome, String email, String crm, Especialidade especialidade) {


    public MedicoDTO(MedicoEntity medico) {
        this(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }
}
