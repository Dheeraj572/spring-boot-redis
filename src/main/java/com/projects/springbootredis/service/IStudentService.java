package com.projects.springbootredis.service;

import java.util.List;

import com.projects.springbootredis.util.StudentResponse;

public interface IStudentService {

	List<StudentResponse> getStudents();
}
