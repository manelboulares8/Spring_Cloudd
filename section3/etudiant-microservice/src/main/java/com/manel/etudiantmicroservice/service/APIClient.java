package com.manel.etudiantmicroservice.service;

import com.manel.etudiantmicroservice.dto.InstitutDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(url = "http://localhost:8083", value = "DEPARTMENT")
public interface APIClient {
    @GetMapping("api/ins/by-nom/{nomInstitut}")
    InstitutDto getInsByNom(@PathVariable String nomInstitut);
}