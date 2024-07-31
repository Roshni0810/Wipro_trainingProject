package com.aecfsp_project2.spring_mysql_crud;

import com.aecfsp_project2.spring_mysql_crud.model.Student;
import com.aecfsp_project2.spring_mysql_crud.model.Users;
import com.aecfsp_project2.spring_mysql_crud.repository.StudentRepository;
import com.aecfsp_project2.spring_mysql_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMysqlCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(SpringMysqlCrudApplication.class, args);}
		@Autowired
		private StudentRepository studentRepository;
		@Override
		public void run(String... args) throws Exception{
			Users user1=new Users();
			user1.setUserName("xyz@mail.com");
			user1.setFullname("xyz");
			user1.setRole("admin");
			//userRepository.save(user1);

			Student student1 = new Student();
			student1.setStudentname("roshni");
			student1.setMobilenumber("98765342");
			student1.setEmail("roshni@mail.com");
			student1.setDepartment("cse");
			student1.setMarks(98);
			//studentRepository.save(student1);

	    }

}
