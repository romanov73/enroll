/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author orion
 */
@Embeddable
public class StudentEduLgotPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "lgot_type_name")
    private String lgotTypeName;
    @Basic(optional = false)
    @Column(name = "student_edu_id")
    private int studentEduId;
    @Basic(optional = false)
    @Column(name = "lgot_date_begin")
    @Temporal(TemporalType.DATE)
    private Date lgotDateBegin;
    @Basic(optional = false)
    @Column(name = "lgot_date_end")
    @Temporal(TemporalType.DATE)
    private Date lgotDateEnd;

    public StudentEduLgotPK() {
    }

    public StudentEduLgotPK(String lgotTypeName, int studentEduId, Date lgotDateBegin, Date lgotDateEnd) {
        this.lgotTypeName = lgotTypeName;
        this.studentEduId = studentEduId;
        this.lgotDateBegin = lgotDateBegin;
        this.lgotDateEnd = lgotDateEnd;
    }

    public String getLgotTypeName() {
        return lgotTypeName;
    }

    public void setLgotTypeName(String lgotTypeName) {
        this.lgotTypeName = lgotTypeName;
    }

    public int getStudentEduId() {
        return studentEduId;
    }

    public void setStudentEduId(int studentEduId) {
        this.studentEduId = studentEduId;
    }

    public Date getLgotDateBegin() {
        return lgotDateBegin;
    }

    public void setLgotDateBegin(Date lgotDateBegin) {
        this.lgotDateBegin = lgotDateBegin;
    }

    public Date getLgotDateEnd() {
        return lgotDateEnd;
    }

    public void setLgotDateEnd(Date lgotDateEnd) {
        this.lgotDateEnd = lgotDateEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgotTypeName != null ? lgotTypeName.hashCode() : 0);
        hash += (int) studentEduId;
        hash += (lgotDateBegin != null ? lgotDateBegin.hashCode() : 0);
        hash += (lgotDateEnd != null ? lgotDateEnd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEduLgotPK)) {
            return false;
        }
        StudentEduLgotPK other = (StudentEduLgotPK) object;
        if ((this.lgotTypeName == null && other.lgotTypeName != null) || (this.lgotTypeName != null && !this.lgotTypeName.equals(other.lgotTypeName))) {
            return false;
        }
        if (this.studentEduId != other.studentEduId) {
            return false;
        }
        if ((this.lgotDateBegin == null && other.lgotDateBegin != null) || (this.lgotDateBegin != null && !this.lgotDateBegin.equals(other.lgotDateBegin))) {
            return false;
        }
        if ((this.lgotDateEnd == null && other.lgotDateEnd != null) || (this.lgotDateEnd != null && !this.lgotDateEnd.equals(other.lgotDateEnd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentEduLgotPK[lgotTypeName=" + lgotTypeName + ", studentEduId=" + studentEduId + ", lgotDateBegin=" + lgotDateBegin + ", lgotDateEnd=" + lgotDateEnd + "]";
    }

}
