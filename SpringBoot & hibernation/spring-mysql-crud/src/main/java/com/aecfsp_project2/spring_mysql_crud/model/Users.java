package com.aecfsp_project2.spring_mysql_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="Fullname",nullable = false)
    private String fullname;

    @Column(name="Username",nullable = false)
    private String userName;

    @Column(name="User_role",nullable = false)
    private String role;


}
