package Main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        // Temporary database
        ArrayList<User> users = new ArrayList<>();

        users.add(new Student("lance", "1234", "2025-001", "Lance test", "2nd Year"));
        users.add(new Student("karlo", "4321", "2025-002", "Karlo test", "1st Year"));
        users.add(new Student("adriel", "1111", "2025-003", "Adriel Test", "3rd Year"));

        users.add(new Admin("admin", "admin123"));

        System.out.println("===== ELMS LOGIN =====");
        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        boolean found = false;

        for (User user : users) {
            if (user.login(u, p)) {
                found = true;

                if (user instanceof Student student) {
                    System.out.println("\nLogin Successful! (STUDENT)");
                    student.viewProfile();
                }

                else if (user instanceof Admin) {
                    System.out.println("\nLogin Successful! (ADMIN)");
                    System.out.println("Admin dashboard will be added later...");
                }

                break;
            }
        }

        if (!found) {
            System.out.println("\nInvalid username or password.");
        }

        sc.close();
    }
}
