
package Main;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
    private List<Student> students = new ArrayList<>();


    public void addStudent(Student s) {
        students.add(s); 
    }
    
    public Student getStudentById(String studentId) {
        for(Student s : students) {
            if(s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }
    
    public List<Student> getAllStudents() { 
        return students; 
    }
}
