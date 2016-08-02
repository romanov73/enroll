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
 * @author osan
 */
@Embeddable
public class StudentEduGrantPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "grant_type_name", nullable = false, length = 255)
    private String grantTypeName;
    @Basic(optional = false)
    @Column(name = "student_edu_id", nullable = false)
    private int studentEduId;
    @Basic(optional = false)
    @Column(name = "grant_date_begin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date grantDateBegin;
    @Basic(optional = false)
    @Column(name = "grant_date_end", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date grantDateEnd;

    public StudentEduGrantPK() {
        
    }

    public StudentEduGrantPK(String grantTypeName, int studentEduId, Date grantDateBegin, Date grantDateEnd) {
        this.grantTypeName = grantTypeName;
        this.studentEduId = studentEduId;
        this.grantDateBegin = grantDateBegin;
        this.grantDateEnd = grantDateEnd;
    }

    public String getGrantTypeName() {
        return grantTypeName;
    }

    public void setGrantTypeName(String grantTypeName) {
        this.grantTypeName = grantTypeName;
    }

    public int getStudentEduId() {
        return studentEduId;
    }

    public void setStudentEduId(int studentEduId) {
        this.studentEduId = studentEduId;
    }

    public Date getGrantDateBegin() {
        return grantDateBegin;
    }

    public void setGrantDateBegin(Date grantDateBegin) {
        this.grantDateBegin = grantDateBegin;
    }

    public Date getGrantDateEnd() {
        return grantDateEnd;
    }

    public void setGrantDateEnd(Date grantDateEnd) {
        this.grantDateEnd = grantDateEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grantTypeName != null ? grantTypeName.hashCode() : 0);
        hash += (int) studentEduId;
        hash += (grantDateBegin != null ? grantDateBegin.hashCode() : 0);
        hash += (grantDateEnd != null ? grantDateEnd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEduGrantPK)) {
            return false;
        }
        StudentEduGrantPK other = (StudentEduGrantPK) object;
        if ((this.grantTypeName == null && other.grantTypeName != null) || (this.grantTypeName != null && !this.grantTypeName.equals(other.grantTypeName))) {
            return false;
        }
        if (this.studentEduId != other.studentEduId) {
            return false;
        }
        if ((this.grantDateBegin == null && other.grantDateBegin != null) || (this.grantDateBegin != null && !this.grantDateBegin.equals(other.grantDateBegin))) {
            return false;
        }
        if ((this.grantDateEnd == null && other.grantDateEnd != null) || (this.grantDateEnd != null && !this.grantDateEnd.equals(other.grantDateEnd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentEduGrantPK[grantTypeName=" + grantTypeName + ", studentEduId=" + studentEduId + ", grantDateBegin=" + grantDateBegin + ", grantDateEnd=" + grantDateEnd + "]";
    }
}
