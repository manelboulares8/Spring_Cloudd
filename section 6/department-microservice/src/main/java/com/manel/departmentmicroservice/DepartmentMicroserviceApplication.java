package com.manel.departmentmicroservice;

import com.manel.departmentmicroservice.entities.Institut;
import com.manel.departmentmicroservice.repos.InstitutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentMicroserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(InstitutRepository institutRepository) {
        return args -> {
            institutRepository.save(Institut.builder()
                    .nomI("ISETN")
                    .localisation("nabeul")
                    .numTlf(1234)
                    .build());
            institutRepository.save(Institut.builder()
                    .nomI("FSEG")
                    .localisation("Tunis")
                    .numTlf(4567)
                    .build());
        };
    }
}
