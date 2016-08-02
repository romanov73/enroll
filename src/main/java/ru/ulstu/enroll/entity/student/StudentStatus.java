/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "student_status", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "StudentStatus.findAll", query = "SELECT s FROM StudentStatus s"), @NamedQuery(name = "StudentStatus.findByStudentStatusName", query = "SELECT s FROM StudentStatus s WHERE s.studentStatusName = :studentStatusName"), @NamedQuery(name = "StudentStatus.findByInsertBy", query = "SELECT s FROM StudentStatus s WHERE s.insertBy = :insertBy"), @NamedQuery(name = "StudentStatus.findByUpdateBy", query = "SELECT s FROM StudentStatus s WHERE s.updateBy = :updateBy"), @NamedQuery(name = "StudentStatus.findByInsertTime", query = "SELECT s FROM StudentStatus s WHERE s.insertTime = :insertTime"), @NamedQuery(name = "StudentStatus.findByUpdateTime", query = "SELECT s FROM StudentStatus s WHERE s.updateTime = :updateTime")})
public class StudentStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "student_status_name", nullable = false, length = 50)
    private String studentStatusName;
    @Column(name = "insert_by", length = 50)
    private String insertBy;
    @Column(name = "update_by", length = 50)
    private String updateBy;
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @OneToMany(mappedBy = "studentStatusParent")
    private Collection<StudentStatus> studentStatusCollection;
    @JoinColumn(name = "student_status_parent", referencedColumnName = "student_status_name")
    @ManyToOne
    private StudentStatus studentStatusParent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentStatusName")
    private Collection<StudentEdu> studentEduCollection;

    public StudentStatus() {
    }

    public StudentStatus(String studentStatusName) {
        this.studentStatusName = studentStatusName;
    }

    public String getStudentStatusName() {
        return studentStatusName;
    }

    public void setStudentStatusName(String studentStatusName) {
        this.studentStatusName = studentStatusName;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public Collection<StudentStatus> getStudentStatusCollection() {
        return studentStatusCollection;
    }

    public void setStudentStatusCollection(Collection<StudentStatus> studentStatusCollection) {
        this.studentStatusCollection = studentStatusCollection;
    }

    public StudentStatus getStudentStatusParent() {
        return studentStatusParent;
    }

    public void setStudentStatusParent(StudentStatus studentStatusParent) {
        this.studentStatusParent = studentStatusParent;
    }

    public Collection<StudentEdu> getStudentEduCollection() {
        return studentEduCollection;
    }

    public void setStudentEduCollection(Collection<StudentEdu> studentEduCollection) {
        this.studentEduCollection = studentEduCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentStatusName != null ? studentStatusName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentStatus)) {
            return false;
        }
        StudentStatus other = (StudentStatus) object;
        if ((this.studentStatusName == null && other.studentStatusName != null) || (this.studentStatusName != null && !this.studentStatusName.equals(other.studentStatusName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentStatus[studentStatusName=" + studentStatusName + "]";
    }

}
