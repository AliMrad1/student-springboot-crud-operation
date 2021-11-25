package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student ali = new Student(
                    "Ali Mrad",
                    "am8396280@gmail.com",
                    LocalDate.of(2002,Month.FEBRUARY,3)
            );
            Student maria = new Student(
                    "Maria Mrad",
                    "maria@gmail.com",
                    LocalDate.of(2017, Month.APRIL,1)
            );

            studentRepository.saveAll(
                    List.of(ali, maria)
            );
        };
    }
}
