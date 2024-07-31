package com.aecfsp_project2.spring_mysql_crud.controller;

import com.aecfsp_project2.spring_mysql_crud.exception.ResourceNotFoundException;
import com.aecfsp_project2.spring_mysql_crud.model.Student;

import com.aecfsp_project2.spring_mysql_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/student/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getAllstudent")
    public List<Student> getAllstudent(){
        return studentRepository.findAll();
    }
    @PostMapping("/addStudent")
    public ResponseEntity<Object> addStudent (@RequestBody Student student){
        Map<String,String> response = new HashMap<>();
        try{
            studentRepository.save(student);
            response.put("status","true");
            response.put("message","user added successfully");
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ex){
            response.put("status","false");
            response.put("message","Internal server error");
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId){
        Student temp = studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("userid not found"));
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int studentId){
        Student temp = studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("userid not found"));

        studentRepository.delete(temp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<Student> updateUser (@PathVariable int studentId,@RequestBody Student std){
        Student temp = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("userid not found"));
        temp.setMarks(std.getMarks());
        temp.setEmail(std.getEmail());
        temp.setDepartment(std.getDepartment());
        temp.setMobilenumber(std.getMobilenumber());
        temp.setStudentname(std.getStudentname());
        studentRepository.save(temp);
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

}
