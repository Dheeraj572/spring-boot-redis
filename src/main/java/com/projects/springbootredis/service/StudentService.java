package com.projects.springbootredis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projects.springbootredis.util.StudentResponse;

@Service
public class StudentService implements IStudentService{

	@Autowired
	private RestTemplate restTemplate;
	
	private ParameterizedTypeReference<List<StudentResponse>> studentTypeReference = new ParameterizedTypeReference<List<StudentResponse>>() {
	};
	
	@Cacheable(value="studentsList")
	public List<StudentResponse> getStudents(){
		
		ResponseEntity<List<StudentResponse>> response = restTemplate.exchange(
				"http://springboot-dockerized-application/students", HttpMethod.GET, null, studentTypeReference);
		List<StudentResponse> studentResponseList = Optional.ofNullable(response).map(mapper -> mapper.getBody())
				.orElse(new ArrayList<>());
		return studentResponseList;
		
	}
	
}
