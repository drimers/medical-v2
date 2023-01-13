package com.stefanpetkov.medical.services;

import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;


    @Autowired
    public CredentialsService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }


    public void save(CredentialsEntity credentials) {
        log.info("CredentialsService:: save()");
        credentialsRepository.save(credentials);
    }
}
