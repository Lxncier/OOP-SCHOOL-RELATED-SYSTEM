
package Main;

public class Grade implements Displayable, Computable {
    private Subject subject;
    private double score;

    public Grade(Subject subject, double score) {
        this.subject = subject;
        this.score = score;
    }
    
    @Override
    public void display(){
        System.out.println(subject.getCode() + " - " + subject.getTitle() + ": " + score);
    }
    
    @Override
    public double compute(){
        return score;
    }
}

