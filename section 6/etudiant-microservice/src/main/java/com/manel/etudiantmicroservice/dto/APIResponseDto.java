package com.manel.etudiantmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EtudiantDto etudiantDto;
    private InstitutDto institutDto;

}
