package com.aecfsp_project2.spring_mysql_crud.controller;

import com.aecfsp_project2.spring_mysql_crud.exception.ResourceNotFoundException;
import com.aecfsp_project2.spring_mysql_crud.model.Users;
import com.aecfsp_project2.spring_mysql_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/users/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllusers")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/addUser")
    public ResponseEntity<Object> adduser(@RequestBody Users users){
        Map<String,String> response = new HashMap<>();
        try{
            userRepository.save(users);
            response.put("status","true");
            response.put("message","user added successfully");
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception ex){
            response.put("status","false");
            response.put("message","Internal server error");
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<Users> getUser(@PathVariable int userId){
        Users temp = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("userid not found"));
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Users> deleteUser(@PathVariable int userId) {
        Users temp = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("userid not found"));
        userRepository.delete(temp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<Users> updateUser (@PathVariable int userId,@RequestBody Users usr){
        Users temp = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("userid not found"));
        temp.setRole(usr.getRole());
        temp.setUserName(usr.getUserName());
        temp.setFullname(usr.getFullname());
        userRepository.save(temp);
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

}
