
package Main;


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
}
