package com.myspringproject.springprj.repository;

import com.myspringproject.springprj.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {

}
