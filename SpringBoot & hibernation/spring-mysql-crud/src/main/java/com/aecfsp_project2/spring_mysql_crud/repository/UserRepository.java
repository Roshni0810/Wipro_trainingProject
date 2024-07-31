package com.aecfsp_project2.spring_mysql_crud.repository;

import com.aecfsp_project2.spring_mysql_crud.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
