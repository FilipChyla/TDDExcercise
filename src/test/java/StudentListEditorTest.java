import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StudentListEditorTest {
    @Test
    void studentShouldBeInListAfterAdding() {
        StudentList studentList = new StudentList();
        StudentListEditor studentListEditor = new StudentListEditor(studentList);
        ArrayList<Student> testStudentList = new ArrayList<>();

        Student student = new Student("Janusz", "Kowalski", 1234);

        testStudentList.add(student);
        studentListEditor.addStudent(student);

        assertThat(studentList.getList()).isEqualTo(testStudentList);
    }

    @Test
    void studentsShouldNotRepeat() {
        StudentList studentList = new StudentList();
        StudentListEditor studentListEditor = new StudentListEditor(studentList);

        Student student = new Student("Janusz", "Kowalski", 1234);

        studentListEditor.addStudent(student);
        studentListEditor.addStudent(student);
        studentListEditor.addStudent(student);

        assertThat(studentList.getList().size()).isEqualTo(1);
    }

    @Test
    void deletedStudentShouldNotBeOnTheList() {
        StudentList studentList = new StudentList();
        StudentListEditor studentListEditor = new StudentListEditor(studentList);
        Student student1 = new Student("Janusz", "Kowalski", 1234);
        Student student2 = new Student("Marian", "Pazdzioch", 3542);
        Student student3 = new Student("Mariusz", "Pudzianowski", 6879);

        studentListEditor.addStudent(student1);
        studentListEditor.addStudent(student2);
        studentListEditor.addStudent(student3);

        studentListEditor.removeStudent(1);

        assertThat(studentList.getList()).doesNotContain(student2);

        studentListEditor.removeStudent(1);
        assertThat(studentList.getList()).doesNotContain(student3);
    }

    @Test
    void editedStudentsShouldHaveTheirInfoChanged() {
        StudentList studentList = new StudentList();
        StudentListEditor studentListEditor = new StudentListEditor(studentList);
        Student student = new Student("Janusz", "Kowalski", 1234);

        studentListEditor.addStudent(student);

        studentListEditor.editStudentFirstName(0, "Marian");
        studentListEditor.editStudentLastName(0, "Pazdzioch");
        studentListEditor.editStudentId(0, 3542);

        assertThat(studentList.getList().get(0).getFirstName()).isEqualTo("Marian");
        assertThat(studentList.getList().get(0).getLastName()).isEqualTo("Pazdzioch");
        assertThat(studentList.getList().get(0).getId()).isEqualTo(3542);
    }
}