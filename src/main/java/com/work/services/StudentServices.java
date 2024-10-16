package com.work.services;

import java.util.List;
import com.work.entities.Student;



public interface StudentServices {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
