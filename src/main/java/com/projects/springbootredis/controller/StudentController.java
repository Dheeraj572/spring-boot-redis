package com.projects.springbootredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springbootredis.service.IStudentService;
import com.projects.springbootredis.util.StudentResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@GetMapping
	public ResponseEntity<?> getStudents(){
		
		log.info("Retrieving student details ---- ");
		
		List<StudentResponse> students = studentService.getStudents();
		
		log.info("Retrieved student details ---- ");
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
}
