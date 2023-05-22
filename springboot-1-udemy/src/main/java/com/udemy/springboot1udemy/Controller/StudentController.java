package com.udemy.springboot1udemy.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springboot1udemy.bean.Student;

@RestController
public class StudentController{

	@GetMapping("/getStudent")
	public Student getStudent() {
		
		Student stu = new Student(1,"Aman","yadav");
		
		return stu;
	}
	
}
