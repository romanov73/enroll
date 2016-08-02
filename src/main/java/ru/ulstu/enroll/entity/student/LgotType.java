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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author osan
 */
@Entity
@Table(name = "lgot_type", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "LgotType.findAll", query = "SELECT l FROM LgotType l"), @NamedQuery(name = "LgotType.findByLgotTypeName", query = "SELECT l FROM LgotType l WHERE l.lgotTypeName = :lgotTypeName"), @NamedQuery(name = "LgotType.findByInsertBy", query = "SELECT l FROM LgotType l WHERE l.insertBy = :insertBy"), @NamedQuery(name = "LgotType.findByUpdateBy", query = "SELECT l FROM LgotType l WHERE l.updateBy = :updateBy"), @NamedQuery(name = "LgotType.findByInsertTime", query = "SELECT l FROM LgotType l WHERE l.insertTime = :insertTime"), @NamedQuery(name = "LgotType.findByUpdateTime", query = "SELECT l FROM LgotType l WHERE l.updateTime = :updateTime")})
public class LgotType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lgot_type_name", nullable = false, length = 150)
    private String lgotTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgotType")
    private Collection<StudentEduLgot> studentEduLgotCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lgotType")
    private LgotGrantType lgotGrantType;

    public LgotType() {
    }

    public LgotType(String lgotTypeName) {
        this.lgotTypeName = lgotTypeName;
    }

    public String getLgotTypeName() {
        return lgotTypeName;
    }

    public void setLgotTypeName(String lgotTypeName) {
        this.lgotTypeName = lgotTypeName;
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

    public Collection<StudentEduLgot> getStudentEduLgotCollection() {
        return studentEduLgotCollection;
    }

    public void setStudentEduLgotCollection(Collection<StudentEduLgot> studentEduLgotCollection) {
        this.studentEduLgotCollection = studentEduLgotCollection;
    }

    public LgotGrantType getLgotGrantType() {
        return lgotGrantType;
    }

    public void setLgotGrantType(LgotGrantType lgotGrantType) {
        this.lgotGrantType = lgotGrantType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgotTypeName != null ? lgotTypeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LgotType)) {
            return false;
        }
        LgotType other = (LgotType) object;
        if ((this.lgotTypeName == null && other.lgotTypeName != null) || (this.lgotTypeName != null && !this.lgotTypeName.equals(other.lgotTypeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LgotType[lgotTypeName=" + lgotTypeName + "]";
    }

}
