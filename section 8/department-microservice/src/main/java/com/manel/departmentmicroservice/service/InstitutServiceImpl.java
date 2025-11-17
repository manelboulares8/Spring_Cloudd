package com.manel.departmentmicroservice.service;

import com.manel.departmentmicroservice.dto.InstitutDto;
import com.manel.departmentmicroservice.entities.Institut;
import com.manel.departmentmicroservice.repos.InstitutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutServiceImpl implements  InstitutService{
    @Autowired
    InstitutRepository institutRepository;
    @Override
    public InstitutDto getInstitutById(long id) {
        Institut ins =institutRepository.findInstitutByIdI(id);
        InstitutDto institutDto =new InstitutDto(
                ins.getIdI(),
                ins.getNomI(),
                ins.getLocalisation(),
                ins.getNumTlf()
        );
        return institutDto;
     }
    @Override
    public InstitutDto getInstitutByNom(String nom) {
        Institut institut = institutRepository.findByNomI(nom)
                .orElseThrow(() -> new RuntimeException("Institut non trouvé avec le nom: " + nom));

        return new InstitutDto(
                institut.getIdI(),
                institut.getNomI(),
                institut.getLocalisation(),
                institut.getNumTlf()
                // autres propriétés...
        );
    }
}
