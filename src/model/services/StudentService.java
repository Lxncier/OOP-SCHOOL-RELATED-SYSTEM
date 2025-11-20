package model.services;

import model.model1.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) { 
        students.add(s); 
        System.out.println("Student added successfully!");
    }
    
    public boolean removeStudent(String studentId) {
        Student student = getStudentById(studentId);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully!");
            return true;
        } else {
            System.out.println("Student with ID " + studentId + " not found!");
            return false;
        }
    }
    
    public Student getStudentById(String id) {
        for(Student s : students) if(s.getStudentId().equals(id)) return s;
        return null;
    }
    
    public boolean studentExists(String studentId) {
        return getStudentById(studentId) != null;
    }
    
    public List<Student> getAllStudents() { return students; }
}