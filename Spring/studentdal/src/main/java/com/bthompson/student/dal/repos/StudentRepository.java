package com.bthompson.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.bthompson.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
