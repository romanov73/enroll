/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.person;

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
@Table(name = "residence", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "Residence.findAll", query = "SELECT r FROM Residence r"), @NamedQuery(name = "Residence.findByResidenceId", query = "SELECT r FROM Residence r WHERE r.residenceId = :residenceId"), @NamedQuery(name = "Residence.findByResidenceName", query = "SELECT r FROM Residence r WHERE r.residenceName = :residenceName"), @NamedQuery(name = "Residence.findByInsertBy", query = "SELECT r FROM Residence r WHERE r.insertBy = :insertBy"), @NamedQuery(name = "Residence.findByUpdateBy", query = "SELECT r FROM Residence r WHERE r.updateBy = :updateBy"), @NamedQuery(name = "Residence.findByInsertTime", query = "SELECT r FROM Residence r WHERE r.insertTime = :insertTime"), @NamedQuery(name = "Residence.findByUpdateTime", query = "SELECT r FROM Residence r WHERE r.updateTime = :updateTime")})
public class Residence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "residence_id", nullable = false, length = 2)
    private String residenceId;
    @Basic(optional = false)
    @Column(name = "residence_name", nullable = false, length = 50)
    private String residenceName;
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
    @OneToMany(mappedBy = "residenceId")
    private Collection<Person> personCollection;

    public Residence() {
    }

    public Residence(String residenceId) {
        this.residenceId = residenceId;
    }

    public Residence(String residenceId, String residenceName) {
        this.residenceId = residenceId;
        this.residenceName = residenceName;
    }

    public String getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(String residenceId) {
        this.residenceId = residenceId;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
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

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (residenceId != null ? residenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Residence)) {
            return false;
        }
        Residence other = (Residence) object;
        if ((this.residenceId == null && other.residenceId != null) || (this.residenceId != null && !this.residenceId.equals(other.residenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Residence[residenceId=" + residenceId + "]";
    }

}
