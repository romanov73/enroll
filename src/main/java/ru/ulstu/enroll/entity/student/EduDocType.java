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
@Table(name = "edu_doc_type", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "EduDocType.findAll", query = "SELECT e FROM EduDocType e"), @NamedQuery(name = "EduDocType.findByInsertBy", query = "SELECT e FROM EduDocType e WHERE e.insertBy = :insertBy"), @NamedQuery(name = "EduDocType.findByUdateBy", query = "SELECT e FROM EduDocType e WHERE e.udateBy = :udateBy"), @NamedQuery(name = "EduDocType.findByInsertTime", query = "SELECT e FROM EduDocType e WHERE e.insertTime = :insertTime"), @NamedQuery(name = "EduDocType.findByUpdateTime", query = "SELECT e FROM EduDocType e WHERE e.updateTime = :updateTime"), @NamedQuery(name = "EduDocType.findByEduDocTypeId", query = "SELECT e FROM EduDocType e WHERE e.eduDocTypeId = :eduDocTypeId"), @NamedQuery(name = "EduDocType.findByEduDocTypeName", query = "SELECT e FROM EduDocType e WHERE e.eduDocTypeName = :eduDocTypeName")})
public class EduDocType implements Serializable {
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
    @Column(name = "edu_doc_type_id", nullable = false, length = 2)
    private String eduDocTypeId;
    @Basic(optional = false)
    @Column(name = "edu_doc_type_name", nullable = false, length = 100)
    private String eduDocTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduDocTypeId")
    private Collection<StudentEduDoc> studentEduDocCollection;

    public EduDocType() {
    }

    public EduDocType(String eduDocTypeId) {
        this.eduDocTypeId = eduDocTypeId;
    }

    public EduDocType(String eduDocTypeId, String eduDocTypeName) {
        this.eduDocTypeId = eduDocTypeId;
        this.eduDocTypeName = eduDocTypeName;
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

    public String getEduDocTypeId() {
        return eduDocTypeId;
    }

    public void setEduDocTypeId(String eduDocTypeId) {
        this.eduDocTypeId = eduDocTypeId;
    }

    public String getEduDocTypeName() {
        return eduDocTypeName;
    }

    public void setEduDocTypeName(String eduDocTypeName) {
        this.eduDocTypeName = eduDocTypeName;
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
        hash += (eduDocTypeId != null ? eduDocTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduDocType)) {
            return false;
        }
        EduDocType other = (EduDocType) object;
        if ((this.eduDocTypeId == null && other.eduDocTypeId != null) || (this.eduDocTypeId != null && !this.eduDocTypeId.equals(other.eduDocTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.EduDocType[eduDocTypeId=" + eduDocTypeId + "]";
    }

}
