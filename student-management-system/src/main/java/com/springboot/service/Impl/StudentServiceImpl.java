package com.springboot.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.Student;
import com.springboot.repository.studentRepository;
import com.springboot.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	private studentRepository studentRepository;
	
	public StudentServiceImpl(com.springboot.repository.studentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public List<Student> getAllStudents() {
		return	studentRepository.findAll();
		 
	}


	@Override
	public Student saveStudent(Student student) {
		studentRepository.save(student);
		return student;
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	
	}


	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	
	}


	@Override
	public void deleteStudentById(Long id) {
			studentRepository.deleteById(id);
	
		
	}
	
	

}
