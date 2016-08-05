package ru.ulstu.enroll.pages.student;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ulstu.enroll.entity.abit.Period;
import ru.ulstu.enroll.entity.student.Student;
import ru.ulstu.enroll.services.JPAController;
import ru.ulstu.enroll.services.QueryParameter;

@Named
@ViewScoped
public class SearchBean implements Serializable {

    @Inject
    private JPAController controller;
    
    private List<Student> students;
    
    private String filter;

    public void init() {
        students = controller.findAll(Student.class, Student.FIND_CURRENT_ENROLL_YEAR, 
                QueryParameter.with("beginPeriod", 
                        controller.findAll(Date.class, 
                                Period.FIND_ALL).stream().reduce((a, b) -> b)
                                .orElse(new Date())
                        ));
    }

    public List<Student> getStudents() {
        if (filter != null && !filter.equals("") && students != null) {
            return students.stream()
                    .filter(s -> 
                            s.getPerson().getSurname().toUpperCase().contains(filter.toUpperCase()) ||
                            s.getPerson().getName().toUpperCase().contains(filter.toUpperCase()) ||
                            s.getPerson().getPatronymic().toUpperCase().contains(filter.toUpperCase()) ||
                            s.getStudentEduList().stream().filter(e -> e.getRegNum().toUpperCase().contains(filter)).collect(Collectors.toList()).size() > 0
                    ).collect(Collectors.toList());
        }
        return students;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
    public String getStudentRegNum(Student student) {
        return students.stream().filter(s 
                -> s.equals(student))
                .findAny()
                .get()
                .getStudentEduList()
                .get(0)
                .getRegNum();
    }
}
