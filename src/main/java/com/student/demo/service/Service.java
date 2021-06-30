package com.student.demo.service;

import java.util.List;

import com.student.demo.entities.Student;


public interface Service {
	
	public List<Student> getAllStudent();
	
	public Student getStudent(int studentid);

	public Student addStudent(Student student);

	public void updateStudent(Student student, int studentid);
	
	public void deleteStudent(int studentid);
	
}
