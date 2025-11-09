package com.manel.departmentmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstitutDto {
    private long idI;
    private String nomI;
    private String localisation;
    private long  numTlf;
}
