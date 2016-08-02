/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ulstu.enroll.entity.person;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "soc_status", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "SocStatus.findAll", query = "SELECT s FROM SocStatus s"), @NamedQuery(name = "SocStatus.findBySocStatusId", query = "SELECT s FROM SocStatus s WHERE s.socStatusId = :socStatusId"), @NamedQuery(name = "SocStatus.findBySocStatusName", query = "SELECT s FROM SocStatus s WHERE s.socStatusName = :socStatusName"), @NamedQuery(name = "SocStatus.findByInsertBy", query = "SELECT s FROM SocStatus s WHERE s.insertBy = :insertBy"), @NamedQuery(name = "SocStatus.findByUpdateBy", query = "SELECT s FROM SocStatus s WHERE s.updateBy = :updateBy"), @NamedQuery(name = "SocStatus.findByInsertTime", query = "SELECT s FROM SocStatus s WHERE s.insertTime = :insertTime"), @NamedQuery(name = "SocStatus.findByUpdateTime", query = "SELECT s FROM SocStatus s WHERE s.updateTime = :updateTime"), @NamedQuery(name = "SocStatus.findByIsParentStatus", query = "SELECT s FROM SocStatus s WHERE s.isParentStatus = :isParentStatus")})
public class SocStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "soc_status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer socStatusId;
    @Basic(optional = false)
    @Column(name = "soc_status_name", nullable = false, length = 50)
    private String socStatusName;
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
    @Column(name = "is_parent_status")
    private Boolean isParentStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socStatus")
    private Collection<PersonSocStatus> personSocStatusCollection;

    public SocStatus() {
    }

    public SocStatus(Integer socStatusId) {
        this.socStatusId = socStatusId;
    }

    public SocStatus(Integer socStatusId, String socStatusName) {
        this.socStatusId = socStatusId;
        this.socStatusName = socStatusName;
    }

    public Integer getSocStatusId() {
        return socStatusId;
    }

    public void setSocStatusId(Integer socStatusId) {
        this.socStatusId = socStatusId;
    }

    public String getSocStatusName() {
        return socStatusName;
    }

    public void setSocStatusName(String socStatusName) {
        this.socStatusName = socStatusName;
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

    public Boolean getIsParentStatus() {
        return isParentStatus;
    }

    public void setIsParentStatus(Boolean isParentStatus) {
        this.isParentStatus = isParentStatus;
    }

    public Collection<PersonSocStatus> getPersonSocStatusCollection() {
        return personSocStatusCollection;
    }

    public void setPersonSocStatusCollection(Collection<PersonSocStatus> personSocStatusCollection) {
        this.personSocStatusCollection = personSocStatusCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socStatusId != null ? socStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocStatus)) {
            return false;
        }
        SocStatus other = (SocStatus) object;
        if ((this.socStatusId == null && other.socStatusId != null) || (this.socStatusId != null && !this.socStatusId.equals(other.socStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SocStatus[socStatusId=" + socStatusId + "]";
    }
}
