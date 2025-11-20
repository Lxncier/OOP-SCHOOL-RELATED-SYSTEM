package model.services;

import model.model1.Student;
import model.model1.Grade;

public class GradeService {
    public void assignGrade(Student student, Grade grade) {
        if (student.hasGradeForSubject(grade.getSubject().getCode())) {
            System.out.println("Grade already exists for this subject. Use edit instead.");
            return;
        }
        student.addGrade(grade);
    }

    public boolean updateGrade(Student student, String subjectCode, double newScore) {
        return student.updateGrade(subjectCode, newScore);
    }
    
    public boolean removeGrade(Student student, String subjectCode) {
        return student.removeGrade(subjectCode);
    }
    
    public void viewStudentGrades(Student student) {
        displayStudentGradesTable(student);
    }

    public void displayStudentGradesTable(Student student) {
        System.out.println("\n============================================================");
        System.out.println("               GRADES FOR " + student.getName().toUpperCase());
        System.out.println("============================================================");
        System.out.printf("%-10s %-30s %-6s\n", "Code", "Subject", "Score");
        System.out.println("------------------------------------------------------------");
        
        if (student.getGrades().isEmpty()) {
            System.out.println("                    No grades found.");
        } else {
            for (Grade grade : student.getGrades()) {
                System.out.println(grade.getFormattedInfo());
            }
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%46s: %6.2f\n", "GPA", student.getGPA());
        System.out.println("============================================================");
    }

    public double computeGPA(Student student) {
        return student.getGPA();
    }
}
