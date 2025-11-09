package com.manel.etudiantmicroservice.repos;

import com.manel.etudiantmicroservice.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
