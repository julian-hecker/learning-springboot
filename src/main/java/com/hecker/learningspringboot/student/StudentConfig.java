package com.hecker.learningspringboot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student bool = new Student("boolean", "boolean@gmail.com", LocalDate.of(1999, Month.DECEMBER, 9));
            Student alex = new Student("alex", "alex@gmail.com", LocalDate.of(2004, Month.DECEMBER, 31));
            repository.saveAll(List.of(bool, alex));
        };
    }
}
