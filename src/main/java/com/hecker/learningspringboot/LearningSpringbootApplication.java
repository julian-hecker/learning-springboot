package com.hecker.learningspringboot;

import com.hecker.learningspringboot.person.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class LearningSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringbootApplication.class, args);
	}

	@GetMapping("/")
	public List<Student> hello() {
		return List.of(
				new Student("boolean", "boolean@gmail.com", LocalDate.of(1999, Month.DECEMBER, 9), 21)
		);
	}
}
