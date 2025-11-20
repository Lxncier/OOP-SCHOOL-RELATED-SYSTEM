package model.model1;

public class Subject {
    private String code;
    private String title;
    private int units;

    public Subject(String code, String title, int units) {
        this.code = code;
        this.title = title;
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getUnits() {
        return units;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnits(int units) {
        this.units = units;
    }
    
    public void displayInfo(){
        System.out.println("Subject Code: " + code + ", Title: " + title + ", Units: " + units);
    }
   
    public String getFormattedInfo() {
        return String.format("%-10s %-30s %-6s", code, title, units);
    }
}
