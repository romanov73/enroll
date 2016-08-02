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
 * @author osan
 */
@Entity
@Table(name = "student_edu_grant", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "StudentEduGrant.findAll", query = "SELECT s FROM StudentEduGrant s"), @NamedQuery(name = "StudentEduGrant.findByInsertBy", query = "SELECT s FROM StudentEduGrant s WHERE s.insertBy = :insertBy"), @NamedQuery(name = "StudentEduGrant.findByUpdateBy", query = "SELECT s FROM StudentEduGrant s WHERE s.updateBy = :updateBy"), @NamedQuery(name = "StudentEduGrant.findByInsertTime", query = "SELECT s FROM StudentEduGrant s WHERE s.insertTime = :insertTime"), @NamedQuery(name = "StudentEduGrant.findByUpdateTime", query = "SELECT s FROM StudentEduGrant s WHERE s.updateTime = :updateTime"), @NamedQuery(name = "StudentEduGrant.findByGrantTypeName", query = "SELECT s FROM StudentEduGrant s WHERE s.studentEduGrantPK.grantTypeName = :grantTypeName"), @NamedQuery(name = "StudentEduGrant.findByStudentEduId", query = "SELECT s FROM StudentEduGrant s WHERE s.studentEduGrantPK.studentEduId = :studentEduId"), @NamedQuery(name = "StudentEduGrant.findByGrantDateBegin", query = "SELECT s FROM StudentEduGrant s WHERE s.studentEduGrantPK.grantDateBegin = :grantDateBegin"), @NamedQuery(name = "StudentEduGrant.findByGrantDateEnd", query = "SELECT s FROM StudentEduGrant s WHERE s.studentEduGrantPK.grantDateEnd = :grantDateEnd"), @NamedQuery(name = "StudentEduGrant.findBySum", query = "SELECT s FROM StudentEduGrant s WHERE s.sum = :sum"), @NamedQuery(name = "StudentEduGrant.findByOrderBitId", query = "SELECT s FROM StudentEduGrant s WHERE s.orderBitId = :orderBitId")})
public class StudentEduGrant implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentEduGrantPK studentEduGrantPK;
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
    @Basic(optional = false)
    @Column(name = "sum", nullable = false)
    private float sum;
    @Basic(optional = false)
    @Column(name = "order_bit_id", nullable = false)
    private int orderBitId;
    @JoinColumn(name = "grant_type_name", referencedColumnName = "grant_type_name", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrantType grantType;
    @JoinColumn(name = "student_edu_id", referencedColumnName = "student_edu_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEdu studentEdu;

    public StudentEduGrant() {
    }

    public StudentEduGrant(StudentEduGrantPK studentEduGrantPK) {
        this.studentEduGrantPK = studentEduGrantPK;
    }

    public StudentEduGrant(StudentEduGrantPK studentEduGrantPK, float sum, int orderBitId) {
        this.studentEduGrantPK = studentEduGrantPK;
        this.sum = sum;
        this.orderBitId = orderBitId;
    }

    public StudentEduGrant(String grantTypeName, int studentEduId, Date grantDateBegin, Date grantDateEnd) {
        this.studentEduGrantPK = new StudentEduGrantPK(grantTypeName, studentEduId, grantDateBegin, grantDateEnd);
    }

    public StudentEduGrantPK getStudentEduGrantPK() {
        return studentEduGrantPK;
    }

    public void setStudentEduGrantPK(StudentEduGrantPK studentEduGrantPK) {
        this.studentEduGrantPK = studentEduGrantPK;
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

    public int getOrderBitId() {
        return orderBitId;
    }

    public void setOrderBitId(int orderBitId) {
        this.orderBitId = orderBitId;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
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
        hash += (studentEduGrantPK != null ? studentEduGrantPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEduGrant)) {
            return false;
        }
        StudentEduGrant other = (StudentEduGrant) object;
        if ((this.studentEduGrantPK == null && other.studentEduGrantPK != null) || (this.studentEduGrantPK != null && !this.studentEduGrantPK.equals(other.studentEduGrantPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentEduGrant[studentEduGrantPK=" + studentEduGrantPK + "]";
    }

}
