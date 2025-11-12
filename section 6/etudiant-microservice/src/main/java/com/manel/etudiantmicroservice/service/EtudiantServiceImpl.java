package com.manel.etudiantmicroservice.service;

import com.manel.etudiantmicroservice.dto.APIResponseDto;
import com.manel.etudiantmicroservice.dto.EtudiantDto;
import com.manel.etudiantmicroservice.dto.InstitutDto;
import com.manel.etudiantmicroservice.entities.Etudiant;
import com.manel.etudiantmicroservice.repos.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements  EtudiantService{
     private EtudiantRepository etudiantRepository;

     private APIClient apiClient;
   // private WebClient webClient;

/*  --------------- AVEC WEB CLIENT ---------------------------
    @Override
    public APIResponseDto getEtudiantById(Long id) {
        Etudiant etudiant =etudiantRepository.findById(id).get();
        InstitutDto institutDto =webClient.get().uri("http://localhost:8083/api/ins/"+
                etudiant.getId())
                .retrieve().
                bodyToMono(InstitutDto.class)
                .block();
        EtudiantDto etudiantDto= new EtudiantDto(
                etudiant.getId(),
                etudiant.getNom(),
                etudiant.getPrenom(),
                etudiant.getCin(),
                etudiant.getDateNaissance(),
                etudiant.getClasse(),
                etudiant.getEmail(),
                etudiant.getNomI()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEtudiantDto(etudiantDto);;
        apiResponseDto.setInstitutDto(institutDto);

        return apiResponseDto;
    }*/
 // ---------------------- AVEC API CLIENT -----------------------------------
    @Override
    public APIResponseDto getEtudiantById(Long id) {
        Etudiant etudiant =etudiantRepository.findById(id).get();
        InstitutDto institutDto=apiClient.getInsByNom(etudiant.getNomI());
        EtudiantDto etudiantDto= new EtudiantDto(
                etudiant.getId(),
                etudiant.getNom(),
                etudiant.getPrenom(),
                etudiant.getCin(),
                etudiant.getDateNaissance(),
                etudiant.getClasse(),
                etudiant.getEmail(),
                etudiant.getNomI(),
                institutDto.getLocalisation()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEtudiantDto(etudiantDto);;
        apiResponseDto.setInstitutDto(institutDto);
        return apiResponseDto;
    }
}
