import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AttendanceListEditorTest {
    @Test
    void presenceShouldBeEqualTrue() {
        //given
        Student student1 = new Student("Janusz", "Kowalski", 1234);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student1)));
        AttendanceList attendanceList = new AttendanceList(studentList, LocalDate.now());
        AttendanceListEditor attendanceListEditor = new AttendanceListEditor(attendanceList);
        //when
        attendanceListEditor.editAttendance(0, true);
        //then
        assertThat(attendanceList.getAttendanceList().get(0)).isEqualTo(true);
    }
    @Test
    void absenceNumberShouldCountAllAbsences(){
        //given
        Student student1 = new Student("Janusz", "Kowalski", 1234);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student1)));
        AttendanceList attendanceList1 = new AttendanceList(studentList, LocalDate.now());
        AttendanceList attendanceList2 = new AttendanceList(studentList, LocalDate.now());
        AttendanceList attendanceList3 = new AttendanceList(studentList, LocalDate.now());
        AttendanceListEditor attendanceListEditor = new AttendanceListEditor(attendanceList1);
        //then
        assertThat(attendanceListEditor.absenceNumber(0)).isEqualTo(3);
    }
    @Test
    void presenceShouldNotCountAsAbsence(){
        //given
        Student student1 = new Student("Janusz", "Kowalski", 1234);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student1)));
        AttendanceList attendanceList1 = new AttendanceList(studentList, LocalDate.now());
        AttendanceList attendanceList2 = new AttendanceList(studentList, LocalDate.now());
        AttendanceList attendanceList3 = new AttendanceList(studentList, LocalDate.now());
        AttendanceListEditor attendanceListEditor = new AttendanceListEditor(attendanceList1);
        //when
        attendanceListEditor.editAttendance(0, true);
        //then
        assertThat(attendanceListEditor.absenceNumber(0)).isEqualTo(2);
    }
}