package com.manel.etudiantmicroservice.restControllers;
import com.manel.etudiantmicroservice.config.Configuration;
import com.manel.etudiantmicroservice.dto.APIResponseDto;
import com.manel.etudiantmicroservice.dto.EtudiantDto;
import com.manel.etudiantmicroservice.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/etudiants")
@AllArgsConstructor
public class EtudiantController {
    private EtudiantService etudiantService;
    @Autowired
    Configuration configuration;
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEtudiantById(@PathVariable ("id")Long id){
        return new ResponseEntity<APIResponseDto>( etudiantService.getEtudiantById(id),HttpStatus.OK);

    }
    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }
}
