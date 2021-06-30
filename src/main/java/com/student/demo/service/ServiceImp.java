package com.student.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.student.demo.entities.Student;

@Component
public class ServiceImp implements Service {
	
	private static List<Student> list = new ArrayList<>();
	
	static {
		list.add(new Student (1, "yash", "odisha"));
		list.add(new Student (2, "Ayusha", "rajasthan"));
		list.add(new Student (3, "ankit", "odisha"));
	}
	
	@Override
	public List<Student> getAllStudent() {
		return list;
	}

	
	public Student getStudent(int studentid) {
		Student student = null;
		student= list.stream().filter(e -> e.getId() == studentid).findFirst().get();
		return student;
	}

	
	public Student addStudent(Student student) {
		list.add(student);
		return student;
	}

	
	
	public void updateStudent(Student student, int studentid) {
		
		list.stream().map(d -> {
			if(d.getId()== studentid) {
				d.setName(student.getName());
				d.setAdr(student.getAdr());
			}
			return d;
		}).collect(Collectors.toList());
	}

	
	public void deleteStudent(int studentid) {
		
		list= list.stream().filter(student -> student.getId() != studentid).collect(Collectors.toList());
		
	}
}
