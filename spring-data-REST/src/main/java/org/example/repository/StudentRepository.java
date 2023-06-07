package org.example.repository;

import org.example.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(collectionResourceRel = "student-api",path = "student-api")
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findStudentsBySection(String section);

}
