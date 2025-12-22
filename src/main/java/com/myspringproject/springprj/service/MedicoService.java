package com.myspringproject.springprj.service;

import com.myspringproject.springprj.dto.MedicoAtualizacaoDTO;
import com.myspringproject.springprj.dto.MedicoDTO;
import com.myspringproject.springprj.entity.MedicoEntity;
import com.myspringproject.springprj.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

//    public List<MedicoDTO> getAll(){
//        List<MedicoEntity> medicoEntityList = medicoRepository.findAll();
//        List<MedicoDTO> medicoDTOList = new ArrayList<>();
//        for (MedicoEntity medicoEntity : medicoEntityList) {
//            medicoDTOList.add(new MedicoDTO(medicoEntity));
//        }
//        return medicoDTOList;
//    }
    public Page<MedicoDTO> listar(Pageable pageable) {
        return medicoRepository
                .findAll(pageable)
                .map(MedicoDTO::new);
    }

    public void deleteById(Long id){
        medicoRepository.deleteById(id);
    }

    public MedicoEntity getMedicoById(Long id){
        return medicoRepository.findById(id).get();
    }
    public MedicoEntity cadastrar(MedicoEntity medicoEntity){
        return medicoRepository.save(medicoEntity);
    }

    @Transactional
    public void atualizar(MedicoAtualizacaoDTO dto) {
        MedicoEntity medico = medicoRepository.getReferenceById(dto.id());

        if (dto.nome() != null) {
            medico.setNome(dto.nome());
        }

        if (dto.telefone() != null) {
            medico.setTelefone(dto.telefone());
        }

        if (dto.endereco() != null) {
            medico.atualizarEndereco(dto.endereco());
        }
    }
}
