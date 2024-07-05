package main;

import bean.Student;
import exception.NullMarksArrayException;
import exception.NullNameException;
import exception.NullStudentObjectException;
import service.StudentReport;
import service.StudentService;

public class StudentMain {
    static Student[] data = new Student[4];

    public StudentMain() {
        for (int i = 0; i < data.length; i++) {
            data[i] = new Student();
        }
        data[0] = new Student("Sekar", new int[]{85, 75, 95});
        data[1] = new Student(null, new int[]{11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);
    }

    public static void main(String[] args) {
        StudentMain sm = new StudentMain();
        StudentReport sr = new StudentReport();
        StudentService ss = new StudentService();

        // Test cases
        // Test findGrades
        try {
            System.out.println("Grade of student 0: " + sr.findGrades(data[0])); // Expected A+
            System.out.println("Grade of student 1: " + sr.findGrades(data[1])); // Expected F
        } catch (Exception e) {
            System.out.println(e);
        }

        // Test validate method
        try {
            System.out.println("Validation of student 0: " + sr.validate(data[0])); // Expected VALID
            System.out.println("Validation of student 1: " + sr.validate(data[1])); // Expected NullNameException
            System.out.println("Validation of student 2: " + sr.validate(data[2])); // Expected NullStudentObjectException
            System.out.println("Validation of student 3: " + sr.validate(data[3])); // Expected NullMarksArrayException
        } catch (NullNameException | NullMarksArrayException | NullStudentObjectException e) {
            System.out.println(e);
        }

        // Test counting methods
        System.out.println("Number of null marks array: " + ss.findNumberOfNullMarksArray(data)); // Expected 1
        System.out.println("Number of null names: " + ss.findNumberOfNullName(data)); // Expected 1
        System.out.println("Number of null objects: " + ss.findNumberOfNullObjects(data)); // Expected 1
    }
}
