package Main;

import java.util.ArrayList;
import java.util.List;


public class Student extends Person implements Displayable {
    private String studentId;
    private String course;
    private List<Grade> grades;

    public Student(String studentID, String course, List<Grade> grades, String name, int age) {
        super(name, age);
        this.studentId = studentID;
        this.course = course;
        this.grades = new ArrayList<>();
    }
    
    public void addGrade(Grade g){
        grades.add(g);
    }
    
    public List<Grade> getGrades(){
        return grades;
    }

    public double getGPA(){
        if(grades.isEmpty()){
            return 0;
        }
        double total = 0;
        for(Grade g : grades) total += g.compute();
        return total / grades.size();           
    }
    
    @Override
    public void displayInfo(){
        System.out.println("\"Student ID: \" + studentId + \", Name: \" + getName() + \", Course: \" + course");
    }
    
    @Override
    public void display(){
        displayInfo();
        for(Grade g : grades) {
            g.display();
        }
        System.out.println("GPA: " + getGPA());
    }
    
    public String getStudentId(){
        return studentId;
    }
}