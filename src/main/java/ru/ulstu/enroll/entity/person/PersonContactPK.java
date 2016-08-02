/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.person;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author osan
 */
@Embeddable
public class PersonContactPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "contact_type_name", nullable = false, length = 50)
    private String contactTypeName;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private int personId;

    public PersonContactPK() {
    }

    public PersonContactPK(String contactTypeName, int personId) {
        this.contactTypeName = contactTypeName;
        this.personId = personId;
    }

    public String getContactTypeName() {
        return contactTypeName;
    }

    public void setContactTypeName(String contactTypeName) {
        this.contactTypeName = contactTypeName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactTypeName != null ? contactTypeName.hashCode() : 0);
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonContactPK)) {
            return false;
        }
        PersonContactPK other = (PersonContactPK) object;
        if ((this.contactTypeName == null && other.contactTypeName != null) || (this.contactTypeName != null && !this.contactTypeName.equals(other.contactTypeName))) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PersonContactPK[contactTypeName=" + contactTypeName + ", personId=" + personId + "]";
    }

}
