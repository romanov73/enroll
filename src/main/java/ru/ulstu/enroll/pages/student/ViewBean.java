package ru.ulstu.enroll.pages.student;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ulstu.enroll.entity.student.Student;
import ru.ulstu.enroll.pages.Page;
import ru.ulstu.enroll.services.JPAController;

@Named
@ViewScoped
public class ViewBean implements Serializable {

    @Inject
    private JPAController controller;

    private Student student;
    
    public String init() {
        if (student == null) {
            return Page.STUDENT_SEARCH;
        }
        return null;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public String deleteStudent() {
        controller.destroy(student);
        return Page.STUDENT_SEARCH;
    }
}
