/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author osan
 */
@Entity
@Table(name = "edu_language", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "EduLanguage.findAll", query = "SELECT e FROM EduLanguage e"), @NamedQuery(name = "EduLanguage.findByInsertBy", query = "SELECT e FROM EduLanguage e WHERE e.insertBy = :insertBy"), @NamedQuery(name = "EduLanguage.findByUdateBy", query = "SELECT e FROM EduLanguage e WHERE e.udateBy = :udateBy"), @NamedQuery(name = "EduLanguage.findByInsertTime", query = "SELECT e FROM EduLanguage e WHERE e.insertTime = :insertTime"), @NamedQuery(name = "EduLanguage.findByUpdateTime", query = "SELECT e FROM EduLanguage e WHERE e.updateTime = :updateTime"), @NamedQuery(name = "EduLanguage.findByLanguageName", query = "SELECT e FROM EduLanguage e WHERE e.languageName = :languageName")})
public class EduLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "insert_by", length = 50)
    private String insertBy;
    @Column(name = "udate_by", length = 50)
    private String udateBy;
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Id
    @Basic(optional = false)
    @Column(name = "language_name", nullable = false, length = 20)
    private String languageName;
    @OneToMany(mappedBy = "languageName")
    private Collection<Student> studentCollection;

    public EduLanguage() {
    }

    public EduLanguage(String languageName) {
        this.languageName = languageName;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public String getUdateBy() {
        return udateBy;
    }

    public void setUdateBy(String udateBy) {
        this.udateBy = udateBy;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageName != null ? languageName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduLanguage)) {
            return false;
        }
        EduLanguage other = (EduLanguage) object;
        if ((this.languageName == null && other.languageName != null) || (this.languageName != null && !this.languageName.equals(other.languageName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.EduLanguage[languageName=" + languageName + "]";
    }

}
