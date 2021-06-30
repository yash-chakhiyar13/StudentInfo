package com.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.entities.Student;
import com.student.demo.service.Service;

@RestController
public class StudentController {
	
	@Autowired
	private Service service;

	@GetMapping(value="/home", produces= MediaType.APPLICATION_JSON_VALUE)
	public String getStudent() {
		return "Students information are here.";
	}
	
	@GetMapping(value="/home/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(service.getAllStudent(), HttpStatus.OK);
	}
	
	
	@GetMapping("/home/students/{studentid}")
	public Student getStudent(@PathVariable("studentid") int studentid) {
		return this.service.getStudent(studentid);
		
	}
	
	@PostMapping("/home/students")
	
//	public Student addStudent(@RequestBody Student student) {
//		Student s= this.service.addStudent(student);
//		System.out.println(student);
//		return s;
//	}
	
	@PutMapping("/home/students/{studentid}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("studentid") int studentid) {
		this.service.updateStudent(student, studentid);
		return student;
	}
	
	
	@DeleteMapping("home/students/{studentid}")
	public void deleteStudent(@PathVariable("studentid") int studentid){
		this.service.deleteStudent(studentid);
		 
	}
}
