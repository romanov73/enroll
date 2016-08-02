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
@Table(name = "edu_institution", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "EduInstitution.findAll", query = "SELECT e FROM EduInstitution e"), @NamedQuery(name = "EduInstitution.findByInsertBy", query = "SELECT e FROM EduInstitution e WHERE e.insertBy = :insertBy"), @NamedQuery(name = "EduInstitution.findByUdateBy", query = "SELECT e FROM EduInstitution e WHERE e.udateBy = :udateBy"), @NamedQuery(name = "EduInstitution.findByInsertTime", query = "SELECT e FROM EduInstitution e WHERE e.insertTime = :insertTime"), @NamedQuery(name = "EduInstitution.findByUpdateTime", query = "SELECT e FROM EduInstitution e WHERE e.updateTime = :updateTime"), @NamedQuery(name = "EduInstitution.findByEduInstitutionId", query = "SELECT e FROM EduInstitution e WHERE e.eduInstitutionId = :eduInstitutionId"), @NamedQuery(name = "EduInstitution.findByEduInstitutionName", query = "SELECT e FROM EduInstitution e WHERE e.eduInstitutionName = :eduInstitutionName")})
public class EduInstitution implements Serializable {
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
    @Column(name = "edu_institution_id", nullable = false, length = 2)
    private String eduInstitutionId;
    @Basic(optional = false)
    @Column(name = "edu_institution_name", nullable = false, length = 100)
    private String eduInstitutionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduInstitutionId")
    private Collection<StudentEduDoc> studentEduDocCollection;

    public EduInstitution() {
    }

    public EduInstitution(String eduInstitutionId) {
        this.eduInstitutionId = eduInstitutionId;
    }

    public EduInstitution(String eduInstitutionId, String eduInstitutionName) {
        this.eduInstitutionId = eduInstitutionId;
        this.eduInstitutionName = eduInstitutionName;
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

    public String getEduInstitutionId() {
        return eduInstitutionId;
    }

    public void setEduInstitutionId(String eduInstitutionId) {
        this.eduInstitutionId = eduInstitutionId;
    }

    public String getEduInstitutionName() {
        return eduInstitutionName;
    }

    public void setEduInstitutionName(String eduInstitutionName) {
        this.eduInstitutionName = eduInstitutionName;
    }

    public Collection<StudentEduDoc> getStudentEduDocCollection() {
        return studentEduDocCollection;
    }

    public void setStudentEduDocCollection(Collection<StudentEduDoc> studentEduDocCollection) {
        this.studentEduDocCollection = studentEduDocCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduInstitutionId != null ? eduInstitutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduInstitution)) {
            return false;
        }
        EduInstitution other = (EduInstitution) object;
        if ((this.eduInstitutionId == null && other.eduInstitutionId != null) || (this.eduInstitutionId != null && !this.eduInstitutionId.equals(other.eduInstitutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.EduInstitution[eduInstitutionId=" + eduInstitutionId + "]";
    }

}
