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
@Table(name = "target", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "Target.findAll", query = "SELECT t FROM Target t"), @NamedQuery(name = "Target.findByInsertBy", query = "SELECT t FROM Target t WHERE t.insertBy = :insertBy"), @NamedQuery(name = "Target.findByUdateBy", query = "SELECT t FROM Target t WHERE t.udateBy = :udateBy"), @NamedQuery(name = "Target.findByInsertTime", query = "SELECT t FROM Target t WHERE t.insertTime = :insertTime"), @NamedQuery(name = "Target.findByUpdateTime", query = "SELECT t FROM Target t WHERE t.updateTime = :updateTime"), @NamedQuery(name = "Target.findByTargetId", query = "SELECT t FROM Target t WHERE t.targetId = :targetId"), @NamedQuery(name = "Target.findByTargetName", query = "SELECT t FROM Target t WHERE t.targetName = :targetName")})
public class Target implements Serializable {
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
    @Column(name = "target_id", nullable = false, length = 20)
    private String targetId;
    @Basic(optional = false)
    @Column(name = "target_name", nullable = false, length = 50)
    private String targetName;
    @OneToMany(mappedBy = "targetId")
    private Collection<StudentEdu> studentEduCollection;

    public Target() {
    }

    public Target(String targetId) {
        this.targetId = targetId;
    }

    public Target(String targetId, String targetName) {
        this.targetId = targetId;
        this.targetName = targetName;
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

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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
        hash += (targetId != null ? targetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Target)) {
            return false;
        }
        Target other = (Target) object;
        if ((this.targetId == null && other.targetId != null) || (this.targetId != null && !this.targetId.equals(other.targetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Target[targetId=" + targetId + "]";
    }

}
