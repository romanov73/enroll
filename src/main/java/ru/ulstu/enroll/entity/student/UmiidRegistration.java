/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author orion
 */
@Entity
@Table(name = "umiid_registration", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "UmiidRegistration.findAll", query = "SELECT u FROM UmiidRegistration u"), @NamedQuery(name = "UmiidRegistration.findByInsertBy", query = "SELECT u FROM UmiidRegistration u WHERE u.insertBy = :insertBy"), @NamedQuery(name = "UmiidRegistration.findByUpdateBy", query = "SELECT u FROM UmiidRegistration u WHERE u.updateBy = :updateBy"), @NamedQuery(name = "UmiidRegistration.findByInsertTime", query = "SELECT u FROM UmiidRegistration u WHERE u.insertTime = :insertTime"), @NamedQuery(name = "UmiidRegistration.findByUpdateTime", query = "SELECT u FROM UmiidRegistration u WHERE u.updateTime = :updateTime"), @NamedQuery(name = "UmiidRegistration.findByStudentId", query = "SELECT u FROM UmiidRegistration u WHERE u.studentId = :studentId"), @NamedQuery(name = "UmiidRegistration.findByCitizenship", query = "SELECT u FROM UmiidRegistration u WHERE u.citizenship = :citizenship"), @NamedQuery(name = "UmiidRegistration.findByMinobrDirectionNum", query = "SELECT u FROM UmiidRegistration u WHERE u.minobrDirectionNum = :minobrDirectionNum"), @NamedQuery(name = "UmiidRegistration.findByMinobrDirectionDate", query = "SELECT u FROM UmiidRegistration u WHERE u.minobrDirectionDate = :minobrDirectionDate"), @NamedQuery(name = "UmiidRegistration.findByUmiidTrain", query = "SELECT u FROM UmiidRegistration u WHERE u.umiidTrain = :umiidTrain")})
public class UmiidRegistration implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "citizenship")
    private String citizenship;
    @Basic(optional = false)
    @Column(name = "minobr_direction_num")
    private String minobrDirectionNum;
    @Basic(optional = false)
    @Column(name = "minobr_direction_date")
    @Temporal(TemporalType.DATE)
    private Date minobrDirectionDate;
    @Basic(optional = false)
    @Column(name = "umiid_train")
    private boolean umiidTrain;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Student student;

    public UmiidRegistration() {
    }

    public UmiidRegistration(Integer studentId) {
        this.studentId = studentId;
    }

    public UmiidRegistration(Integer studentId, String minobrDirectionNum, Date minobrDirectionDate, boolean umiidTrain) {
        this.studentId = studentId;
        this.minobrDirectionNum = minobrDirectionNum;
        this.minobrDirectionDate = minobrDirectionDate;
        this.umiidTrain = umiidTrain;
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getMinobrDirectionNum() {
        return minobrDirectionNum;
    }

    public void setMinobrDirectionNum(String minobrDirectionNum) {
        this.minobrDirectionNum = minobrDirectionNum;
    }

    public Date getMinobrDirectionDate() {
        return minobrDirectionDate;
    }

    public void setMinobrDirectionDate(Date minobrDirectionDate) {
        this.minobrDirectionDate = minobrDirectionDate;
    }

    public boolean getUmiidTrain() {
        return umiidTrain;
    }

    public void setUmiidTrain(boolean umiidTrain) {
        this.umiidTrain = umiidTrain;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UmiidRegistration)) {
            return false;
        }
        UmiidRegistration other = (UmiidRegistration) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.UmiidRegistration[studentId=" + studentId + "]";
    }

}
