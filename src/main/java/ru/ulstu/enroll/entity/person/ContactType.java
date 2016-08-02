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
@Table(name = "contact_type", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c"), @NamedQuery(name = "ContactType.findByContactTypeName", query = "SELECT c FROM ContactType c WHERE c.contactTypeName = :contactTypeName"), @NamedQuery(name = "ContactType.findByInsertBy", query = "SELECT c FROM ContactType c WHERE c.insertBy = :insertBy"), @NamedQuery(name = "ContactType.findByUpdateBy", query = "SELECT c FROM ContactType c WHERE c.updateBy = :updateBy"), @NamedQuery(name = "ContactType.findByInsertTime", query = "SELECT c FROM ContactType c WHERE c.insertTime = :insertTime"), @NamedQuery(name = "ContactType.findByUpdateTime", query = "SELECT c FROM ContactType c WHERE c.updateTime = :updateTime")})
public class ContactType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contact_type_name", nullable = false, length = 50)
    private String contactTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactType")
    private Collection<PersonContact> personContactCollection;

    public ContactType() {
    }

    public ContactType(String contactTypeName) {
        this.contactTypeName = contactTypeName;
    }

    public String getContactTypeName() {
        return contactTypeName;
    }

    public void setContactTypeName(String contactTypeName) {
        this.contactTypeName = contactTypeName;
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

    public Collection<PersonContact> getPersonContactCollection() {
        return personContactCollection;
    }

    public void setPersonContactCollection(Collection<PersonContact> personContactCollection) {
        this.personContactCollection = personContactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactTypeName != null ? contactTypeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactType)) {
            return false;
        }
        ContactType other = (ContactType) object;
        if ((this.contactTypeName == null && other.contactTypeName != null) || (this.contactTypeName != null && !this.contactTypeName.equals(other.contactTypeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ContactType[contactTypeName=" + contactTypeName + "]";
    }

}
