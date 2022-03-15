public class AttendanceListEditor {
    private AttendanceList attendanceList;

    public AttendanceListEditor(AttendanceList attendanceList) {
        this.attendanceList = attendanceList;
    }

    public void editAttendance(int studentIndex, boolean isPresent) {
        attendanceList.getAttendanceList().set(studentIndex, isPresent);
    }

    public int absenceNumber(int studentIndex) {
        int absences = 0;
        for (AttendanceList lecture : AttendanceList.getLecturesList()) {
            if (!lecture.getAttendanceList().get(studentIndex)) {
                absences++;
            }
        }
        return absences;
    }
}
