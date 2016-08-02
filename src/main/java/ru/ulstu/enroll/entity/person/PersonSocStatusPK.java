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
public class PersonSocStatusPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "soc_status_id", nullable = false)
    private int socStatusId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private int personId;

    public PersonSocStatusPK() {
    }

    public PersonSocStatusPK(int socStatusId, int personId) {
        this.socStatusId = socStatusId;
        this.personId = personId;
    }

    public int getSocStatusId() {
        return socStatusId;
    }

    public void setSocStatusId(int socStatusId) {
        this.socStatusId = socStatusId;
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
        hash += (int) socStatusId;
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonSocStatusPK)) {
            return false;
        }
        PersonSocStatusPK other = (PersonSocStatusPK) object;
        if (this.socStatusId != other.socStatusId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PersonSocStatusPK[socStatusId=" + socStatusId + ", personId=" + personId + "]";
    }

}
