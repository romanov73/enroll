/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author orion
 */
@Entity
@Table(name = "student_edu_lgot", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "StudentEduLgot.findAll", query = "SELECT s FROM StudentEduLgot s"), @NamedQuery(name = "StudentEduLgot.findByInsertBy", query = "SELECT s FROM StudentEduLgot s WHERE s.insertBy = :insertBy"), @NamedQuery(name = "StudentEduLgot.findByUpdateBy", query = "SELECT s FROM StudentEduLgot s WHERE s.updateBy = :updateBy"), @NamedQuery(name = "StudentEduLgot.findByInsertTime", query = "SELECT s FROM StudentEduLgot s WHERE s.insertTime = :insertTime"), @NamedQuery(name = "StudentEduLgot.findByUpdateTime", query = "SELECT s FROM StudentEduLgot s WHERE s.updateTime = :updateTime"), @NamedQuery(name = "StudentEduLgot.findByLgotTypeName", query = "SELECT s FROM StudentEduLgot s WHERE s.studentEduLgotPK.lgotTypeName = :lgotTypeName"), @NamedQuery(name = "StudentEduLgot.findByStudentEduId", query = "SELECT s FROM StudentEduLgot s WHERE s.studentEduLgotPK.studentEduId = :studentEduId"), @NamedQuery(name = "StudentEduLgot.findByLgotDateBegin", query = "SELECT s FROM StudentEduLgot s WHERE s.studentEduLgotPK.lgotDateBegin = :lgotDateBegin"), @NamedQuery(name = "StudentEduLgot.findByLgotDateEnd", query = "SELECT s FROM StudentEduLgot s WHERE s.studentEduLgotPK.lgotDateEnd = :lgotDateEnd"), @NamedQuery(name = "StudentEduLgot.findBySum", query = "SELECT s FROM StudentEduLgot s WHERE s.sum = :sum")})
public class StudentEduLgot implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentEduLgotPK studentEduLgotPK;
    @Column(name = "insert_by")
    private String insertBy;
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Basic(optional = false)
    @Column(name = "sum")
    private float sum;
    @JoinColumn(name = "lgot_doc_id", referencedColumnName = "lgot_doc_id")
    @ManyToOne
    private LgotDoc lgotDocId;
    @JoinColumn(name = "lgot_type_name", referencedColumnName = "lgot_type_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LgotType lgotType;
    @JoinColumn(name = "student_edu_id", referencedColumnName = "student_edu_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEdu studentEdu;

    public StudentEduLgot() {
    }

    public StudentEduLgot(StudentEduLgotPK studentEduLgotPK) {
        this.studentEduLgotPK = studentEduLgotPK;
    }

    public StudentEduLgot(StudentEduLgotPK studentEduLgotPK, float sum) {
        this.studentEduLgotPK = studentEduLgotPK;
        this.sum = sum;
    }

    public StudentEduLgot(String lgotTypeName, int studentEduId, Date lgotDateBegin, Date lgotDateEnd) {
        this.studentEduLgotPK = new StudentEduLgotPK(lgotTypeName, studentEduId, lgotDateBegin, lgotDateEnd);
    }

    public StudentEduLgotPK getStudentEduLgotPK() {
        return studentEduLgotPK;
    }

    public void setStudentEduLgotPK(StudentEduLgotPK studentEduLgotPK) {
        this.studentEduLgotPK = studentEduLgotPK;
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

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public LgotDoc getLgotDocId() {
        return lgotDocId;
    }

    public void setLgotDocId(LgotDoc lgotDocId) {
        this.lgotDocId = lgotDocId;
    }

    public LgotType getLgotType() {
        return lgotType;
    }

    public void setLgotType(LgotType lgotType) {
        this.lgotType = lgotType;
    }

    public StudentEdu getStudentEdu() {
        return studentEdu;
    }

    public void setStudentEdu(StudentEdu studentEdu) {
        this.studentEdu = studentEdu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentEduLgotPK != null ? studentEduLgotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEduLgot)) {
            return false;
        }
        StudentEduLgot other = (StudentEduLgot) object;
        if ((this.studentEduLgotPK == null && other.studentEduLgotPK != null) || (this.studentEduLgotPK != null && !this.studentEduLgotPK.equals(other.studentEduLgotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentEduLgot[studentEduLgotPK=" + studentEduLgotPK + "]";
    }

}
