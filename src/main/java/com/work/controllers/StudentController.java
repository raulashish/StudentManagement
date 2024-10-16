package com.work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.work.services.StudentServices;
import com.work.entities.Student;


@Controller
public class StudentController {

	@Autowired
	private StudentServices studentService;

	public StudentController(StudentServices studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return model and view
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student=new Student();
		model.addAttribute("student",student);
		return "Create_Student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
	      studentService.saveStudent(student);
	return "redirect:/students";
	
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "Edit_Student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
		@ModelAttribute("student") Student student,
		Model model) {
			
			// get student from database by id
			Student existingStudent = studentService.getStudentById(id);
			existingStudent.setId(id);
			existingStudent.setFirstname(student.getFirstname());
			existingStudent.setLastname(student.getLastname());
			existingStudent.setEmail(student.getEmail());
			
			// save update student object
			studentService.updateStudent(existingStudent);
			return "redirect:/students";
			
		}
	
	    // handler method to handle delete student request
	    @GetMapping("/students/{id}")
	    public String deleteStudent(@PathVariable Long id) {
	          studentService.deleteStudentById(id);
	          return "redirect:/students";
	    	
	    }
	}

