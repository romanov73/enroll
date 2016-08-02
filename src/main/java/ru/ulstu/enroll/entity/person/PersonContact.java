/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.person;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author osan
 */
@Entity
@Table(name = "person_contact", catalog = "sp", schema = "person", uniqueConstraints = {@UniqueConstraint(columnNames = {"person_id", "contact_type_name"})})
@NamedQueries({@NamedQuery(name = "PersonContact.findAll", query = "SELECT p FROM PersonContact p"), @NamedQuery(name = "PersonContact.findByContactTypeName", query = "SELECT p FROM PersonContact p WHERE p.personContactPK.contactTypeName = :contactTypeName"), @NamedQuery(name = "PersonContact.findByPersonContactValue", query = "SELECT p FROM PersonContact p WHERE p.personContactValue = :personContactValue"), @NamedQuery(name = "PersonContact.findByInsertBy", query = "SELECT p FROM PersonContact p WHERE p.insertBy = :insertBy"), @NamedQuery(name = "PersonContact.findByUpdateBy", query = "SELECT p FROM PersonContact p WHERE p.updateBy = :updateBy"), @NamedQuery(name = "PersonContact.findByInsertTime", query = "SELECT p FROM PersonContact p WHERE p.insertTime = :insertTime"), @NamedQuery(name = "PersonContact.findByUpdateTime", query = "SELECT p FROM PersonContact p WHERE p.updateTime = :updateTime"), @NamedQuery(name = "PersonContact.findByPersonId", query = "SELECT p FROM PersonContact p WHERE p.personContactPK.personId = :personId")})
public class PersonContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonContactPK personContactPK;
    @Basic(optional = false)
    @Column(name = "person_contact_value", nullable = false, length = 50)
    private String personContactValue;
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
    @JoinColumn(name = "contact_type_name", referencedColumnName = "contact_type_name", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ContactType contactType;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public PersonContact() {
    }

    public PersonContact(PersonContactPK personContactPK) {
        this.personContactPK = personContactPK;
    }

    public PersonContact(PersonContactPK personContactPK, String personContactValue) {
        this.personContactPK = personContactPK;
        this.personContactValue = personContactValue;
    }

    public PersonContact(String contactTypeName, int personId) {
        this.personContactPK = new PersonContactPK(contactTypeName, personId);
    }

    public PersonContactPK getPersonContactPK() {
        return personContactPK;
    }

    public void setPersonContactPK(PersonContactPK personContactPK) {
        this.personContactPK = personContactPK;
    }

    public String getPersonContactValue() {
        return personContactValue;
    }

    public void setPersonContactValue(String personContactValue) {
        this.personContactValue = personContactValue;
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

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personContactPK != null ? personContactPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonContact)) {
            return false;
        }
        PersonContact other = (PersonContact) object;
        if ((this.personContactPK == null && other.personContactPK != null) || (this.personContactPK != null && !this.personContactPK.equals(other.personContactPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PersonContact[personContactPK=" + personContactPK + "]";
    }

}
