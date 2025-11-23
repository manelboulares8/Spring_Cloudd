package com.manel.departmentmicroservice.service;

import com.manel.departmentmicroservice.dto.InstitutDto;

public interface InstitutService {
    InstitutDto getInstitutById(long id);
    InstitutDto getInstitutByNom(String nom);


}
