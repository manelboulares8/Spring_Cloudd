package com.manel.departmentmicroservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Institut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idI;
    private String nomI;
    private String localisation;
    private long  numTlf;
}