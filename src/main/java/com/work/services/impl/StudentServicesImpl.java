package com.work.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.work.entities.Student;
import com.work.repositories.StudentRepository;
import com.work.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices{

	@Autowired
	private StudentRepository studentRepository;
	
	
	public StudentServicesImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents(){
     		return studentRepository.findAll();
	}
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get();
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

}
