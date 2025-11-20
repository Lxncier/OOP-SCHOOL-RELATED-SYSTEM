package model.menus;

import java.util.Scanner;
import model.services.StudentService;
import model.services.GradeService;
import model.services.SubjectService;
import model.model1.Student;
import model.model1.Subject;
import model.model1.Grade;

public class MenuManager {
    private Scanner sc;
    private StudentService studentService;
    private GradeService gradeService;
    private SubjectService subjectService;

    public MenuManager(Scanner sc, StudentService studentService, GradeService gradeService, SubjectService subjectService) {
        this.sc = sc;
        this.studentService = studentService;
        this.gradeService = gradeService;
        this.subjectService = subjectService;
    }

    public void adminMenu() {
        while(true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Grades");
            System.out.println("3. Manage Subjects");
            System.out.println("4. View All Students");
            System.out.println("5. View All Grades");
            System.out.println("6. Logout");
            System.out.print("Choice: ");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 -> manageStudentsMenu();
                case 2 -> manageGradesMenu();
                case 3 -> manageSubjectsMenu();
                case 4 -> viewAllStudents();
                case 5 -> viewAllGrades();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void manageStudentsMenu() {
        while(true) {
            System.out.println("\n===== MANAGE STUDENTS =====");
            System.out.println("1. View All Students");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Back");
            System.out.print("Choice: ");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 -> viewAllStudents();
                case 2 -> addStudentMenu();
                case 3 -> removeStudentMenu();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void manageGradesMenu() {
        while(true) {
            System.out.println("\n===== MANAGE GRADES =====");
            System.out.println("1. View All Students with Grades");
            System.out.println("2. Assign Grade to Student");
            System.out.println("3. Edit Student Grade");
            System.out.println("4. Remove Student Grade");
            System.out.println("5. View Specific Student Grades");
            System.out.println("6. Back");
            System.out.print("Choice: ");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 -> viewAllGrades();
                case 2 -> assignGradeToStudent();
                case 3 -> editStudentGrade();
                case 4 -> removeStudentGrade();
                case 5 -> viewSpecificStudentGrades();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void addStudentMenu() {
        System.out.println("\n===== ADD STUDENT =====");
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();
        
        if (studentService.studentExists(studentId)) {
            System.out.println("Student with ID " + studentId + " already exists!");
            return;
        }
        
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        Student newStudent = new Student(studentId, name, age, course, password);
        studentService.addStudent(newStudent);
    }

    public void removeStudentMenu() {
        System.out.println("\n===== REMOVE STUDENT =====");
        System.out.print("Enter Student ID to remove: ");
        String studentId = sc.nextLine();
        studentService.removeStudent(studentId);
    }

    public void assignGradeToStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = studentService.getStudentById(id);
        if(s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Available Subjects:");
        subjectService.viewAllSubjects();
        
        System.out.print("Enter subject code: ");
        String subjectCode = sc.nextLine();
        
        Subject subject = subjectService.getSubject(subjectCode);
        if(subject == null) {
            System.out.println("Subject not found!");
            return;
        }

        System.out.print("Score: ");
        double score = sc.nextDouble(); sc.nextLine();

        gradeService.assignGrade(s, new Grade(subject, score));
        System.out.println("Grade assigned!");
    }

    public void editStudentGrade() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = studentService.getStudentById(id);
        if(s == null) {
            System.out.println("Student not found.");
            return;
        }

        // Show current grades
        gradeService.displayStudentGradesTable(s);
        
        if (s.getGrades().isEmpty()) {
            System.out.println("No grades to edit.");
            return;
        }
        
        System.out.print("Enter subject code to edit: ");
        String subjectCode = sc.nextLine();
        
        System.out.print("Enter new score: ");
        double newScore = sc.nextDouble(); sc.nextLine();

        if(gradeService.updateGrade(s, subjectCode, newScore)) {
            System.out.println("Grade updated successfully!");
            System.out.println("Updated grades:");
            gradeService.viewStudentGrades(s);
        } else {
            System.out.println("Grade not found for subject: " + subjectCode);
        }
    }

    public void removeStudentGrade() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = studentService.getStudentById(id);
        if(s == null) {
            System.out.println("Student not found.");
            return;
        }

        // Show current grades
        gradeService.displayStudentGradesTable(s);
        
        if (s.getGrades().isEmpty()) {
            System.out.println("No grades to remove.");
            return;
        }
        
        System.out.print("Enter subject code to remove: ");
        String subjectCode = sc.nextLine();

        if(gradeService.removeGrade(s, subjectCode)) {
            System.out.println("Grade removed successfully!");
            System.out.println("Updated grades:");
            gradeService.viewStudentGrades(s);
        } else {
            System.out.println("Grade not found for subject: " + subjectCode);
        }
    }

    public void viewSpecificStudentGrades() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = studentService.getStudentById(id);
        if(s == null) {
            System.out.println("Student not found.");
            return;
        }

        gradeService.displayStudentGradesTable(s);
    }

    public void manageSubjectsMenu() {
        while(true) {
            System.out.println("\n===== MANAGE SUBJECTS =====");
            System.out.println("1. Add Subject");
            System.out.println("2. Delete Subject");
            System.out.println("3. View All Subjects");
            System.out.println("4. Back");
            System.out.print("Choice: ");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 ->                     {
                        System.out.print("Enter subject code: ");
                        String code = sc.nextLine();
                        System.out.print("Enter subject title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter subject units: ");
                        int units = sc.nextInt();
                        sc.nextLine();
                        subjectService.addSubject(code, title, units);
                    }
                case 2 ->                     {
                        System.out.print("Enter subject code to delete: ");
                        String code = sc.nextLine();
                        subjectService.deleteSubject(code);
                    }
                case 3 -> subjectService.viewAllSubjects();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void displayAllStudentsTable() {
        System.out.println("\n============================================================");
        System.out.println("                    STUDENT RECORDS");
        System.out.println("============================================================");
        System.out.printf("%-12s %-20s %-6s %-10s\n", "Student ID", "Name", "Age", "Course");
        System.out.println("------------------------------------------------------------");
        
        if (studentService.getAllStudents().isEmpty()) {
            System.out.println("                    No students found.");
        } else {
            for(Student s : studentService.getAllStudents()) {
                System.out.println(s.getFormattedInfo());
            }
        }
        System.out.println("============================================================");
    }

    public void displayAllGradesTable() {
        System.out.println("\n============================================================");
        System.out.println("                    ALL STUDENTS GRADES");
        System.out.println("============================================================");
        
        if (studentService.getAllStudents().isEmpty()) {
            System.out.println("                    No students found.");
            System.out.println("============================================================");
            return;
        }

        for(Student s : studentService.getAllStudents()) {
            System.out.println("\nSTUDENT: " + s.getFormattedInfo());
            System.out.printf("%-10s %-30s %-6s\n", "Code", "Subject", "Score");
            System.out.println("------------------------------------------------------------");
            
            if (s.getGrades().isEmpty()) {
                System.out.println("                    No grades found.");
            } else {
                for (Grade grade : s.getGrades()) {
                    System.out.println(grade.getFormattedInfo());
                }
            }
            System.out.printf("%46s: %6.2f\n", "GPA", s.getGPA());
            System.out.println("------------------------------------------------------------");
        }
        System.out.println("============================================================");
    }
    
    public void viewAllStudents() {
        displayAllStudentsTable();
    }

    public void viewAllGrades() {
        displayAllGradesTable();
    }

    public void studentMenu(Student s) {
        while(true) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("                   STUDENT PORTAL");
            System.out.println("=".repeat(60));
            System.out.println("Welcome, " + s.getName() + "!");
            System.out.println("1. View My Profile");
            System.out.println("2. View My Grades");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int c = sc.nextInt(); sc.nextLine();

            if(c == 1) {
                System.out.println("\n============================================================");
                System.out.println("                      MY PROFILE");
                System.out.println("============================================================");
                System.out.printf("%-12s %-20s %-6s %-10s\n", "Student ID", "Name", "Age", "Course");
                System.out.println("------------------------------------------------------------");
                System.out.println(s.getFormattedInfo());
                System.out.println("============================================================");
            } else if(c == 2) {
                gradeService.displayStudentGradesTable(s);
            } else if(c == 3) {
                System.out.println("Logging out...");
                return;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

