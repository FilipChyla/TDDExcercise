import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private ArrayList<Integer> markList = new ArrayList<>();

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }


    public ArrayList<Integer> getMarkList() {
        return markList;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + '\'' +
                ", last name: " + lastName + '\'' +
                ", id: " + id;
    }
}
