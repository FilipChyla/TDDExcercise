import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MarkListEditorTest {
    @Test
    void afterAddingMarkShouldBeOnTheList() {
        //given
        Student student = new Student("Janusz", "Kowalski", 1234);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student)));
        MarkListEditor markListEditor = new MarkListEditor(studentList);
        //when
        ArrayList<Integer> testMarkList = new ArrayList<>(List.of(4));
        markListEditor.addMark(0, 4);
        //then
        assertThat(studentList.getList().get(0).getMarkList()).isEqualTo(testMarkList);
    }

    @Test
    void editedMarkShouldChange() {
        //given
        Student student = new Student("Janusz", "Kowalski", 1234);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student)));
        MarkListEditor markListEditor = new MarkListEditor(studentList);
        //when
        ArrayList<Integer> testMarkList = new ArrayList<>(List.of(2));
        markListEditor.addMark(0, 4);
        markListEditor.editMark(0, 0, 2);
        //then
        assertThat(studentList.getList().get(0).getMarkList()).isEqualTo(testMarkList);
    }

    @Test
    void studentMeanGradeShouldReturnCorrectNumber() {
        //given
        Student student = new Student("Janusz", "Kowalski", 1234);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student)));
        MarkListEditor markListEditor = new MarkListEditor(studentList);
        //when
        markListEditor.addMark(0, 4);
        markListEditor.addMark(0, 3);
        markListEditor.addMark(0, 2);
        markListEditor.addMark(0, 1);
        //then
        assertThat(markListEditor.studentAverageGrade(0)).isEqualTo(2.5f);
    }

    @Test
    void groupMeanGradeShouldReturnCorrectNumber() {
        //given
        Student student1 = new Student("Janusz", "Kowalski", 1234);
        Student student2 = new Student("Marian", "Kowalski", 4321);
        StudentList studentList = new StudentList(new ArrayList<>(List.of(student1, student2)));
        MarkListEditor markListEditor = new MarkListEditor(studentList);
        //when
        markListEditor.addMark(0, 4);
        markListEditor.addMark(0, 3);
        markListEditor.addMark(1, 2);
        markListEditor.addMark(1, 1);
        //then
        assertThat(markListEditor.groupAverageGrade()).isEqualTo(2.5f);
    }
}