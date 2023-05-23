package com.udemy.springboot1udemy.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springboot1udemy.bean.Student;

@RestController
public class StudentController{

	@GetMapping("/getStudent")
	public Student getStudent() {
		
		Student stu = new Student(1,"Aman","yadav");
		
		return stu;
	}
	
	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1,"Aman","yadav"));
		list.add(new Student(2,"gaurav","dhamal"));
		list.add(new Student(3,"rajat","yadav"));
		list.add(new Student(4,"abhay","mishra"));
		list.add(new Student(5,"Harshit","rai"));
		
		return list;
	}
	
	
	
	@GetMapping("students/{id}/{first-name}/{last-name}")
	public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName) {
		
		return new Student(studentId, firstName, lastName);	
		
	}
	
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student studentRequestBody(@RequestBody Student student) {
		
		System.out.println(student.getStuid());
		System.out.println(student.getFirstname());
		System.out.println(student.getLastname());
		
		return student;
	
	}
	
	
	
}
