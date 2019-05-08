package com.bthompson.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bthompson.student.dal.entities.Student;
import com.bthompson.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setName("Jax");
		student.setCourse("Java Web Services 106");
		student.setFee(30d);
		
		studentRepository.save(student);
		
	}
	
	@Test
	public void testFindStudentById() {
		Optional<Student> findById = studentRepository.findById(1l);
		System.out.println(findById);
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = studentRepository.findById(1l).get();
        student.setFee(40d);
        
        studentRepository.save(student);
	}
	
	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(1l);
		studentRepository.deleteById(1l);
	}

}
