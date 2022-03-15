public class MarkListEditor {
    private StudentList studentList;

    public MarkListEditor(StudentList studentList) {
        this.studentList = studentList;
    }

    public void addMark(int studentIndex, int mark) {
        studentList.getList().get(studentIndex).getMarkList().add(mark);
    }

    public void editMark(int studentIndex, int markIndex, int mark) {
        studentList.getList().get(studentIndex).getMarkList().set(markIndex, mark);
    }

    public float studentAverageGrade(int studentIndex) {
        float sum = 0;
        int grades = 0;
        for (Integer grade : studentList.getList().get(studentIndex).getMarkList()) {
            sum += grade;
            grades++;
        }
        if (grades == 0) {
            return 0;
        } else {
            return sum / grades;
        }
    }

    public float groupAverageGrade() {
        float sum = 0;
        int grades = 0;
        for (Student student : studentList.getList()) {
            for(Integer grade:student.getMarkList()){
                sum+=grade;
                grades++;
            }
        }

        if (grades == 0) {
            return 0;
        } else {
            return sum / grades;
        }
    }
}
