package com.myspringproject.springprj.controller;

import com.myspringproject.springprj.dto.MedicoAtualizacaoDTO;
import com.myspringproject.springprj.dto.MedicoDTO;
import com.myspringproject.springprj.dto.MedicoResponseDTO;
import com.myspringproject.springprj.entity.MedicoEntity;
import com.myspringproject.springprj.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> cadastrar(@RequestBody MedicoDTO medicoDTO) {
        MedicoEntity medico = medicoService.cadastrar(medicoDTO);

        URI uri = URI.create("/medicos/" + medico.getId());

        return ResponseEntity
                .created(uri)
                .body(new MedicoResponseDTO(medico));
    }

//    @GetMapping
//    public ResponseEntity<List<MedicoDTO>> findAll(){
//        return ResponseEntity.ok(medicoService.getAll());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> getMedico(@PathVariable Long id){
        MedicoEntity medico = medicoService.getMedicoById(id);
        MedicoResponseDTO medicoResponseDTO = new MedicoResponseDTO(medico);
        return ResponseEntity.ok(medicoResponseDTO);
    }
    @GetMapping
    public Page<MedicoResponseDTO> listar(@PageableDefault(size = 5) Pageable pageable) {
        return medicoService.listar(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicoById(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping
    public ResponseEntity<Void> atualizar(@RequestBody MedicoAtualizacaoDTO dto) {
        medicoService.atualizar(dto);
        return ResponseEntity.noContent().build();
    }

}
