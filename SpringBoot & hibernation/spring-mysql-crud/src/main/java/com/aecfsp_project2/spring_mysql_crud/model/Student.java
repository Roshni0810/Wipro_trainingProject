package com.aecfsp_project2.spring_mysql_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studenId;

    @Column(name = "s_name",nullable = false)
    private String studentname;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "Mobile_no",nullable = false)
    private String mobilenumber;

    @Column(name = "Department",nullable = false)
    private String department;

    @Column(name = "Marks",nullable = false)
    private int marks;

}
