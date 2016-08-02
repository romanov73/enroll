package ru.ulstu.enroll.pages.student;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ulstu.enroll.entity.abit.Period;
import ru.ulstu.enroll.entity.student.Student;
import ru.ulstu.enroll.services.JPAController;
import ru.ulstu.enroll.services.QueryParameter;

@Named
@ViewScoped
public class StudentSearchBean implements Serializable {

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
                        ), 100);
        if (filter != null && !filter.equals("")) {
            students = students.stream().filter(s -> s.getPerson().getSurname().contains(filter)).collect(Collectors.toList());
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
 
    public void doFilter() {
        System.out.println(filter);
    }    
}
