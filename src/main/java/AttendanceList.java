import java.time.LocalDate;
import java.util.ArrayList;

public class AttendanceList {
    private static ArrayList<AttendanceList> lecturesList = new ArrayList<>();
    private LocalDate lectureDate;
    private ArrayList<Boolean> attendanceList = new ArrayList<>();
    private StudentList studentList;

    public AttendanceList(StudentList studentList, LocalDate lectureDate) {
        for(int i=0;i<studentList.getList().size();i++){
            attendanceList.add(false);
        }
        this.studentList = studentList;
        this.lectureDate = lectureDate;
        lecturesList.add(this);
    }

    public static ArrayList<AttendanceList> getLecturesList() {
        return lecturesList;
    }

    public LocalDate getLectureDate() {
        return lectureDate;
    }

    public ArrayList<Boolean> getAttendanceList() {
        return attendanceList;
    }

    public StudentList getStudentList() {
        return studentList;
    }

}
