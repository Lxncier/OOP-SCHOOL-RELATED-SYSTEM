
package Main;

class Student extends User implements Profile {
    private String studentID;
    private String fullName;
    private String gradeLevel;

    public Student(String username, String password, String studentID, String fullName, String gradeLevel) {
        super(username, password);
        this.studentID = studentID;
        this.fullName = fullName;
        this.gradeLevel = gradeLevel;
    }
    
    @Override
    public boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    @Override
    public void viewProfile() {
        System.out.println("\n===== STUDENT PROFILE =====");
        System.out.println("Student ID : " + studentID);
        System.out.println("Full Name  : " + fullName);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("===========================\n");
    }
}
