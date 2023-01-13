package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Long> {


    PatientEntity findAllById(Long id);
}
