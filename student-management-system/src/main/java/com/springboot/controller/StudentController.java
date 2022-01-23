package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.entity.Student;
import com.springboot.repository.studentRepository;
import com.springboot.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to get all student and return model & view
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());   // <tr th:each =  " student: ${students}"> // ${students} comes from the model in this line to refer in students.html
		//return students.html 
		return "students";
	}
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);   //<form th:action = "@{/students}" th:object = "${student}">  // ${student} comes from the model in this line to refer in create_student.html
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";		 //redirecting to /students RUL i.e. above listStudents method
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id , Model model) { 
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
		
	}
	
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id , @ModelAttribute("student") Student student , Model model) {
		
		// get student from DB by Id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated object student
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id ) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
