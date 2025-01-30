package com.Project.repo;


import org.springframework.data.repository.CrudRepository;

import com.Project.model.Student;



public interface StudentRepo extends CrudRepository<Student, Integer> {
	
	Student findByStudentId(int studentId);
	
	
}