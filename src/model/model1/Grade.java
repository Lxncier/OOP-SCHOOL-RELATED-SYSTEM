package model.model1;

import model.interfaces.Displayable;
import model.interfaces.Computable;

public class Grade implements Displayable, Computable {
    private Subject subject;
    private double score;

    public Grade(Subject subject, double score) {
        this.subject = subject;
        this.score = score;
    }
    
    public Subject getSubject() { 
        return subject;
    }
    
    public void setScore(double score) {
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
    
    public String getFormattedInfo() {
        return String.format("%-10s %-30s %-6.2f", subject.getCode(), subject.getTitle(), score);
    }
}

