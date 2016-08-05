package ru.ulstu.enroll.pages.student;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import ru.ulstu.enroll.entity.person.Person;
import ru.ulstu.enroll.entity.student.Student;
import ru.ulstu.enroll.services.JPAController;
import ru.ulstu.enroll.services.QueryParameter;

@Named
public class StudentConverter implements Converter {
        
    @Inject
    private JPAController controller;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.trim().equals("")) {
            return controller.find(Student.class, Student.FIND_BY_ID, QueryParameter.with("studentId", new Long(value)));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Person person = ((Student)value).getPerson();
        return person.getSurname() + " " +person.getName() + " " + person.getPatronymic();
    }

}
