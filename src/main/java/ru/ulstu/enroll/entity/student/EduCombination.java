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
@Table(name = "edu_combination", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "EduCombination.findAll", query = "SELECT e FROM EduCombination e"), @NamedQuery(name = "EduCombination.findByInsertBy", query = "SELECT e FROM EduCombination e WHERE e.insertBy = :insertBy"), @NamedQuery(name = "EduCombination.findByUdateBy", query = "SELECT e FROM EduCombination e WHERE e.udateBy = :udateBy"), @NamedQuery(name = "EduCombination.findByInsertTime", query = "SELECT e FROM EduCombination e WHERE e.insertTime = :insertTime"), @NamedQuery(name = "EduCombination.findByUpdateTime", query = "SELECT e FROM EduCombination e WHERE e.updateTime = :updateTime"), @NamedQuery(name = "EduCombination.findByEduCombinationId", query = "SELECT e FROM EduCombination e WHERE e.eduCombinationId = :eduCombinationId"), @NamedQuery(name = "EduCombination.findByEduCombinationName", query = "SELECT e FROM EduCombination e WHERE e.eduCombinationName = :eduCombinationName")})
public class EduCombination implements Serializable {
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
    @Column(name = "edu_combination_id", nullable = false)
    private Integer eduCombinationId;
    @Basic(optional = false)
    @Column(name = "edu_combination_name", nullable = false, length = 50)
    private String eduCombinationName;
    @OneToMany(mappedBy = "eduCombinationId")
    private Collection<Student> studentCollection;

    public EduCombination() {
    }

    public EduCombination(Integer eduCombinationId) {
        this.eduCombinationId = eduCombinationId;
    }

    public EduCombination(Integer eduCombinationId, String eduCombinationName) {
        this.eduCombinationId = eduCombinationId;
        this.eduCombinationName = eduCombinationName;
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

    public Integer getEduCombinationId() {
        return eduCombinationId;
    }

    public void setEduCombinationId(Integer eduCombinationId) {
        this.eduCombinationId = eduCombinationId;
    }

    public String getEduCombinationName() {
        return eduCombinationName;
    }

    public void setEduCombinationName(String eduCombinationName) {
        this.eduCombinationName = eduCombinationName;
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
        hash += (eduCombinationId != null ? eduCombinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduCombination)) {
            return false;
        }
        EduCombination other = (EduCombination) object;
        if ((this.eduCombinationId == null && other.eduCombinationId != null) || (this.eduCombinationId != null && !this.eduCombinationId.equals(other.eduCombinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.EduCombination[eduCombinationId=" + eduCombinationId + "]";
    }

}
