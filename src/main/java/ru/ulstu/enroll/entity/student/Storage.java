package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "storage", catalog = "sp", schema = "student")
@NamedQueries({
    @NamedQuery(name = Storage.FIND_ALL, query = "SELECT s FROM Storage s")
})
public class Storage implements Serializable {

    public static final String FIND_ALL = "Storage.findAll";
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
