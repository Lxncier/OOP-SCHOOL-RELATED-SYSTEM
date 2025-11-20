package model.services;

import model.model1.Subject;
import java.util.HashMap;
import java.util.Map;

public class SubjectService {
    private Map<String, Subject> subjects = new HashMap<>();
    
    public void addSubject(String code, String title, int units) {
        if (subjects.containsKey(code)) {
            System.out.println("Subject with code " + code + " already exists!");
            return;
        }
        subjects.put(code, new Subject(code, title, units));
        System.out.println("Subject added successfully!");
    }
    
    public void deleteSubject(String code) {
        if (subjects.remove(code) != null) {
            System.out.println("Subject deleted successfully!");
        } else {
            System.out.println("Subject with code " + code + " not found!");
        }
    }
    
    public void viewAllSubjects() {
        displayAllSubjectsTable();
    }
    
    public void displayAllSubjectsTable() {
        System.out.println("\n============================================================");
        System.out.println("                      SUBJECT RECORDS");
        System.out.println("============================================================");
        System.out.printf("%-10s %-30s %-6s\n", "Code", "Title", "Units");
        System.out.println("------------------------------------------------------------");
        
        if (subjects.isEmpty()) {
            System.out.println("                    No subjects found.");
        } else {
            for (Subject subject : subjects.values()) {
                System.out.println(subject.getFormattedInfo());
            }
        }
        System.out.println("============================================================");
    }

    public Subject getSubject(String code) {
        return subjects.get(code);
    }
    
    public boolean subjectExists(String code) {
        return subjects.containsKey(code);
    }
}
