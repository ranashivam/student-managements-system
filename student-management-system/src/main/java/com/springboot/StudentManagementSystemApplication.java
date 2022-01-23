package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.entity.Student;
import com.springboot.repository.studentRepository;
import com.springboot.service.StudentService;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	
	@Autowired
	private studentRepository studentRepository1;

	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Shivam", "Rana", "shivam@gmail.com");
//		studentRepository1.save(student1);
	}
	
	

}
 