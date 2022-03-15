
public class StudentListEditor {
    private StudentList studentList;

    public StudentListEditor(StudentList studentList){
        this.studentList =studentList;
    }

    public void addStudent(Student student) {
        boolean exists = false;

        for (Student loopStudent : studentList.getList()) {
            if (loopStudent.toString().equalsIgnoreCase(student.toString())) {
                exists = true;
                System.err.println("This student already exists");
            }
        }

        if (!exists) {
            studentList.getList().add(student);
        }
    }

    public void removeStudent(int listIndex) {
        if (listIndex >= 0 && listIndex < studentList.getList().size()) {
            studentList.getList().remove(listIndex);
        }else{
            System.err.println("Wrong index!");
        }

    }
    public void editStudentFirstName(int listIndex, String firstName){
        studentList.getList().get(listIndex).setFirstName(firstName);
    }
    public void editStudentLastName(int listIndex, String lastName){
        studentList.getList().get(listIndex).setLastName(lastName);
    }
    public void editStudentId(int listIndex, int id){
        studentList.getList().get(listIndex).setId(id);
    }

}
