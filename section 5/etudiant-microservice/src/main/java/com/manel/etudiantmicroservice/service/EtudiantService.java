package com.manel.etudiantmicroservice.service;

import com.manel.etudiantmicroservice.dto.APIResponseDto;
import com.manel.etudiantmicroservice.dto.EtudiantDto;

public interface EtudiantService {
    APIResponseDto getEtudiantById(Long id);
}
