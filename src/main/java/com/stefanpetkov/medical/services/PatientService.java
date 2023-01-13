package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



    public void save(PatientEntity patient) {
        log.info("PatientService:: save()");
        patientRepository.save(patient);
    }

}
