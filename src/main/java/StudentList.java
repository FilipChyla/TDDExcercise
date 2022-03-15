import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentList(ArrayList<Student> studentList){
        this.studentList=studentList;
    }
    public StudentList(){}

    public ArrayList<Student> getList(){
        return studentList;
    }
}
