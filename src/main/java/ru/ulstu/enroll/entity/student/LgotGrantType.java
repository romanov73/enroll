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
 * @author osan
 */
@Entity
@Table(name = "lgot_grant_type", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "LgotGrantType.findAll", query = "SELECT l FROM LgotGrantType l"), @NamedQuery(name = "LgotGrantType.findByLgotTypeName", query = "SELECT l FROM LgotGrantType l WHERE l.lgotTypeName = :lgotTypeName"), @NamedQuery(name = "LgotGrantType.findBySum", query = "SELECT l FROM LgotGrantType l WHERE l.sum = :sum"), @NamedQuery(name = "LgotGrantType.findByInsertBy", query = "SELECT l FROM LgotGrantType l WHERE l.insertBy = :insertBy"), @NamedQuery(name = "LgotGrantType.findByUpdateBy", query = "SELECT l FROM LgotGrantType l WHERE l.updateBy = :updateBy"), @NamedQuery(name = "LgotGrantType.findByInsertTime", query = "SELECT l FROM LgotGrantType l WHERE l.insertTime = :insertTime"), @NamedQuery(name = "LgotGrantType.findByUpdateTime", query = "SELECT l FROM LgotGrantType l WHERE l.updateTime = :updateTime")})
public class LgotGrantType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lgot_type_name", nullable = false, length = 150)
    private String lgotTypeName;
    @Basic(optional = false)
    @Column(name = "sum", nullable = false)
    private float sum;
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
    @JoinColumn(name = "lgot_type_name", referencedColumnName = "lgot_type_name", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private LgotType lgotType;

    public LgotGrantType() {
    }

    public LgotGrantType(String lgotTypeName) {
        this.lgotTypeName = lgotTypeName;
    }

    public LgotGrantType(String lgotTypeName, float sum) {
        this.lgotTypeName = lgotTypeName;
        this.sum = sum;
    }

    public String getLgotTypeName() {
        return lgotTypeName;
    }

    public void setLgotTypeName(String lgotTypeName) {
        this.lgotTypeName = lgotTypeName;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
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

    public LgotType getLgotType() {
        return lgotType;
    }

    public void setLgotType(LgotType lgotType) {
        this.lgotType = lgotType;
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
        if (!(object instanceof LgotGrantType)) {
            return false;
        }
        LgotGrantType other = (LgotGrantType) object;
        if ((this.lgotTypeName == null && other.lgotTypeName != null) || (this.lgotTypeName != null && !this.lgotTypeName.equals(other.lgotTypeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LgotGrantType[lgotTypeName=" + lgotTypeName + "]";
    }

}
