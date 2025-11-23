package com.manel.etudiantmicroservice.service;

import com.manel.etudiantmicroservice.dto.InstitutDto;
import org.springframework.stereotype.Component;

@Component
public class DeptFallBack implements APIClient {


    @Override
    public InstitutDto getInsByNom(String nomInstitut) {
        return null;
    }
}