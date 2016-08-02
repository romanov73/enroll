/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.person;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author osan
 */
@Entity
@Table(name = "person_soc_status", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "PersonSocStatus.findAll", query = "SELECT p FROM PersonSocStatus p"), @NamedQuery(name = "PersonSocStatus.findByInsertBy", query = "SELECT p FROM PersonSocStatus p WHERE p.insertBy = :insertBy"), @NamedQuery(name = "PersonSocStatus.findByUpdateBy", query = "SELECT p FROM PersonSocStatus p WHERE p.updateBy = :updateBy"), @NamedQuery(name = "PersonSocStatus.findByInsertTime", query = "SELECT p FROM PersonSocStatus p WHERE p.insertTime = :insertTime"), @NamedQuery(name = "PersonSocStatus.findByUpdateTime", query = "SELECT p FROM PersonSocStatus p WHERE p.updateTime = :updateTime"), @NamedQuery(name = "PersonSocStatus.findBySocStatusId", query = "SELECT p FROM PersonSocStatus p WHERE p.personSocStatusPK.socStatusId = :socStatusId"), @NamedQuery(name = "PersonSocStatus.findByPersonId", query = "SELECT p FROM PersonSocStatus p WHERE p.personSocStatusPK.personId = :personId")})
public class PersonSocStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonSocStatusPK personSocStatusPK;
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
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "soc_status_id", referencedColumnName = "soc_status_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SocStatus socStatus;

    public PersonSocStatus() {
    }

    public PersonSocStatus(PersonSocStatusPK personSocStatusPK) {
        this.personSocStatusPK = personSocStatusPK;
    }

    public PersonSocStatus(int socStatusId, int personId) {
        this.personSocStatusPK = new PersonSocStatusPK(socStatusId, personId);
    }

    public PersonSocStatusPK getPersonSocStatusPK() {
        return personSocStatusPK;
    }

    public void setPersonSocStatusPK(PersonSocStatusPK personSocStatusPK) {
        this.personSocStatusPK = personSocStatusPK;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public SocStatus getSocStatus() {
        return socStatus;
    }

    public void setSocStatus(SocStatus socStatus) {
        this.socStatus = socStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personSocStatusPK != null ? personSocStatusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonSocStatus)) {
            return false;
        }
        PersonSocStatus other = (PersonSocStatus) object;
        if ((this.personSocStatusPK == null && other.personSocStatusPK != null) || (this.personSocStatusPK != null && !this.personSocStatusPK.equals(other.personSocStatusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PersonSocStatus[personSocStatusPK=" + personSocStatusPK + "]";
    }

}
