package com.manel.etudiantmicroservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDto {
    private long id;

    private String nom;
    private String prenom;
    private long cin;
    private String dateNaissance;
    private String classe;
    private String email;
    private String nomI;
    private String localisation;

}
