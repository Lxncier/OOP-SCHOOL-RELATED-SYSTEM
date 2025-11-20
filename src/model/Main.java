package model;

import java.util.Scanner;
import model.services.StudentService;
import model.services.GradeService;
import model.services.SubjectService;
import model.model1.Student;
import model.menus.MenuManager;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("admin", "1234");
        StudentService studentService = new StudentService();
        GradeService gradeService = new GradeService();
        SubjectService subjectService = new SubjectService();
        MenuManager menuManager = new MenuManager(sc, studentService, gradeService, subjectService);

        // Add some sample subjects
        subjectService.addSubject("MATH101", "Calculus", 3);
        subjectService.addSubject("ENG102", "English", 3);
        subjectService.addSubject("CS101", "Introduction to Programming", 4);

        // Sample students
        studentService.addStudent(new Student("ID0001", "Albert Einstein", 19, "BSCS", "1234"));
        studentService.addStudent(new Student("ID0002", "Jose Rizal", 20, "BSIT", "1234"));

        while(true) {
            System.out.println("\n===== SIMS LOGIN =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            if(choice == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();

                if(admin.login(u, p)) {
                    menuManager.adminMenu();
                } else {
                    System.out.println("Invalid admin login.");
                }

            } else if(choice == 2) {
                System.out.print("Student ID: ");
                String id = sc.nextLine();
                System.out.print("Password: ");
                String pass = sc.nextLine();

                Student s = studentService.getStudentById(id);
                if(s != null && s.login(id, pass)) {
                    menuManager.studentMenu(s);
                } else {
                    System.out.println("Invalid student login.");
                }

            } else if(choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}