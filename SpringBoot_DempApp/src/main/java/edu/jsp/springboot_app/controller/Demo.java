package edu.jsp.springboot_app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.springboot_app.dto.Student;

@RestController
public class Demo {
	
	
	@RequestMapping(method = RequestMethod.GET,value = "get")
	public String hello() {
		return "HELLO WORLD";
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "name")
	public List<String> name(){
		return Arrays.asList("Tom","Jerry","Dinga","Dingi");
	}

	@RequestMapping(method = RequestMethod.GET,value = "getStudent")
	public Student getStdDetails() {
		Student s=new Student();
		s.setId(1);
		s.setName("tom");
		s.setSub("java");
		s.setAge(25);
		s.setMarks(96.5);
		return s;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "listofstudent")
	public List<Student> listOfStudent(){
		
		Student s1=new Student();
		s1.setId(101);
		s1.setName("gopal");
		s1.setSub("java");
		s1.setAge(30);
		s1.setMarks(51.5);
		
		Student s2=new Student();
		s2.setId(102);
		s2.setName("thanapal");
		s2.setSub("j2ee");
		s2.setAge(25);
		s2.setMarks(75.5);
		
		
		Student s3=new Student();
		s3.setId(103);
		s3.setName("rampal");
		s3.setSub("SQL");
		s3.setAge(20);
		s3.setMarks(40.5);
		
		List list=new ArrayList<>();
		list.add(s3);
		list.add(s2);
		list.add(s1);
		
		return list;
	}
}
