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
@Table(name = "grant_type", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "GrantType.findAll", query = "SELECT g FROM GrantType g"), @NamedQuery(name = "GrantType.findByGrantTypeName", query = "SELECT g FROM GrantType g WHERE g.grantTypeName = :grantTypeName"), @NamedQuery(name = "GrantType.findByInsertBy", query = "SELECT g FROM GrantType g WHERE g.insertBy = :insertBy"), @NamedQuery(name = "GrantType.findByUpdateBy", query = "SELECT g FROM GrantType g WHERE g.updateBy = :updateBy"), @NamedQuery(name = "GrantType.findByInsertTime", query = "SELECT g FROM GrantType g WHERE g.insertTime = :insertTime"), @NamedQuery(name = "GrantType.findByUpdateTime", query = "SELECT g FROM GrantType g WHERE g.updateTime = :updateTime"), @NamedQuery(name = "GrantType.findBySum", query = "SELECT g FROM GrantType g WHERE g.sum = :sum")})
public class GrantType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "grant_type_name", nullable = false, length = 255)
    private String grantTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grantType")
    private Collection<StudentEduGrant> studentEduGrantCollection;

    public GrantType() {
    }

    public GrantType(String grantTypeName) {
        this.grantTypeName = grantTypeName;
    }

    public GrantType(String grantTypeName, float sum) {
        this.grantTypeName = grantTypeName;
        this.sum = sum;
    }

    public String getGrantTypeName() {
        return grantTypeName;
    }

    public void setGrantTypeName(String grantTypeName) {
        this.grantTypeName = grantTypeName;
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

    public Collection<StudentEduGrant> getStudentEduGrantCollection() {
        return studentEduGrantCollection;
    }

    public void setStudentEduGrantCollection(Collection<StudentEduGrant> studentEduGrantCollection) {
        this.studentEduGrantCollection = studentEduGrantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grantTypeName != null ? grantTypeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrantType)) {
            return false;
        }
        GrantType other = (GrantType) object;
        if ((this.grantTypeName == null && other.grantTypeName != null) || (this.grantTypeName != null && !this.grantTypeName.equals(other.grantTypeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.GrantType[grantTypeName=" + grantTypeName + "]";
    }

}
