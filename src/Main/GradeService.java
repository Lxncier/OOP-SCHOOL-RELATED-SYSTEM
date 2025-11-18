
package Main;

public class GradeService {
    public void assignGrade(Student student, Grade grade){
        student.addGrade(grade);
    }
    
    public double computeGPA(Student student){
        return student.getGPA();
    }
}
