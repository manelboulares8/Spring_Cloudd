package com.manel.departmentmicroservice.restControllers;

import com.manel.departmentmicroservice.config.Configuration;
import com.manel.departmentmicroservice.dto.InstitutDto;
import com.manel.departmentmicroservice.entities.Institut;
import com.manel.departmentmicroservice.repos.InstitutRepository;
import com.manel.departmentmicroservice.service.InstitutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ins")

public class InstitutController {
    private InstitutService institutService;
    InstitutRepository institutRepository;

 /*   @Value("${build.version}")
    private String buildVersion;
    @Autowired
    Configuration configuration;
*/
    public  InstitutController(InstitutService institutService){
        this.institutService=institutService;
    }

    @GetMapping("{id}")
    public ResponseEntity<InstitutDto> getInsById(@PathVariable("id") long id) {
        return new ResponseEntity<InstitutDto>(
                institutService.getInstitutById(id), HttpStatus.OK);
    }

    @GetMapping("/by-nom/{nom}")
    public ResponseEntity<InstitutDto> getInsByNom(@PathVariable("nom") String nom){
        return new ResponseEntity<>(
                institutService.getInstitutByNom(nom), HttpStatus.OK);
    }
/*
    @GetMapping("/version")
    public ResponseEntity<String> version()
    {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }*/
}



