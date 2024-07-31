package com.aecfsp_project2.spring_mysql_crud.repository;

import com.aecfsp_project2.spring_mysql_crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
