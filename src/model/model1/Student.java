package model.model1;

import model.interfaces.Displayable;
import java.util.ArrayList;
import java.util.List;


public class Student extends Person implements Displayable {
    private String studentId;
    private String course;
    private String password;
    private List<Grade> grades;

    public Student(String studentId, String name, int age, String course, String password) {
        super(name, age);
        this.studentId = studentId;
        this.course = course;
        this.password = password;
        this.grades = new ArrayList<>();
    }
    
    public boolean login(String id, String pass){
        return studentId.equals(id) && password.equals(pass);
    }
    
    public void addGrade(Grade g){
        grades.add(g);
    }
    
    public List<Grade> getGrades(){
        return grades;
    }
    
    public String getStudentId(){
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public double getGPA(){
        if(grades.isEmpty()){
            return 0;
        }
        double total = 0;
        for(Grade g : grades) total += g.compute();
        return total / grades.size();           
    }
    
    public boolean updateGrade(String subjectCode, double newScore) {
        for (Grade grade : grades) {
            if (grade.getSubject().getCode().equals(subjectCode)) {   
                grade.setScore(newScore);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeGrade(String subjectCode) {
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getSubject().getCode().equals(subjectCode)) {
                grades.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean hasGradeForSubject(String subjectCode) {
        for (Grade grade : grades) {
            if (grade.getSubject().getCode().equals(subjectCode)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + studentId + ", Name: " + getName() + ", Age: " + getAge() + ", Course: " + course);
    }
   
    public String getFormattedInfo(){
        return String.format("%-12s %-20s %-6s %-10s", studentId, getName(), getAge(), course);
    }
    
    @Override
    public void display(){
        displayInfo();
        for(Grade g : grades) {
            g.display();
        }
        System.out.println("GPA: " + getGPA());
    }
}
  