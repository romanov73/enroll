package ru.ulstu.enroll.pages;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Page implements Serializable {
    public static final String HEADER = "header.xhtml";
    public static final String MENU = "menu.xhtml";
    public static final String MAIN = "/index.xhtml";
    public static final String STUDENT = "student/";
    public static final String STUDENT_SEARCH = "/student/studentSearch.xhtml";
    public static final String STUDENT_VIEW = "view";
       
    public String getHEADER() {
        return HEADER;
    }

    public String getMENU() {
        return MENU;
    }

    public String getSTUDENT_SEARCH() {
        return STUDENT_SEARCH;
    }
        
    public String getHeaderTitle() {
        return "Абитуриент - "  + Calendar.getInstance().get(Calendar.YEAR);
    }

    public String getMAIN() {
        return MAIN;
    }

    public String getSTUDENT_VIEW() {
        return STUDENT_VIEW;
    }
    
}
