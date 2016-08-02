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
@Table(name = "address_born", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "AddressBorn.findAll", query = "SELECT a FROM AddressBorn a"), @NamedQuery(name = "AddressBorn.findByAddressBornId", query = "SELECT a FROM AddressBorn a WHERE a.addressBornId = :addressBornId"), @NamedQuery(name = "AddressBorn.findByInsertBy", query = "SELECT a FROM AddressBorn a WHERE a.insertBy = :insertBy"), @NamedQuery(name = "AddressBorn.findByUpdateBy", query = "SELECT a FROM AddressBorn a WHERE a.updateBy = :updateBy"), @NamedQuery(name = "AddressBorn.findByInsertTime", query = "SELECT a FROM AddressBorn a WHERE a.insertTime = :insertTime"), @NamedQuery(name = "AddressBorn.findByUpdateTime", query = "SELECT a FROM AddressBorn a WHERE a.updateTime = :updateTime"), @NamedQuery(name = "AddressBorn.findByBirthCountry", query = "SELECT a FROM AddressBorn a WHERE a.birthCountry = :birthCountry"), @NamedQuery(name = "AddressBorn.findByBirthRegion", query = "SELECT a FROM AddressBorn a WHERE a.birthRegion = :birthRegion"), @NamedQuery(name = "AddressBorn.findByBirthArea", query = "SELECT a FROM AddressBorn a WHERE a.birthArea = :birthArea"), @NamedQuery(name = "AddressBorn.findByBirthPunkt", query = "SELECT a FROM AddressBorn a WHERE a.birthPunkt = :birthPunkt")})
public class AddressBorn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_born_id", nullable = false)
    private Integer addressBornId;
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
    @Column(name = "birth_country", nullable = false, length = 50)
    private String birthCountry;
    @Column(name = "birth_region", length = 100)
    private String birthRegion;
    @Column(name = "birth_area", length = 100)
    private String birthArea;
    @Column(name = "birth_punkt", length = 100)
    private String birthPunkt;
    @OneToMany(mappedBy = "addressBornId")
    private Collection<Person> personCollection;

    public AddressBorn() {
    }

    public AddressBorn(Integer addressBornId) {
        this.addressBornId = addressBornId;
    }

    public AddressBorn(Integer addressBornId, String birthCountry) {
        this.addressBornId = addressBornId;
        this.birthCountry = birthCountry;
    }

    public Integer getAddressBornId() {
        return addressBornId;
    }

    public void setAddressBornId(Integer addressBornId) {
        this.addressBornId = addressBornId;
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

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthRegion() {
        return birthRegion;
    }

    public void setBirthRegion(String birthRegion) {
        this.birthRegion = birthRegion;
    }

    public String getBirthArea() {
        return birthArea;
    }

    public void setBirthArea(String birthArea) {
        this.birthArea = birthArea;
    }

    public String getBirthPunkt() {
        return birthPunkt;
    }

    public void setBirthPunkt(String birthPunkt) {
        this.birthPunkt = birthPunkt;
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
        hash += (addressBornId != null ? addressBornId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressBorn)) {
            return false;
        }
        AddressBorn other = (AddressBorn) object;
        if ((this.addressBornId == null && other.addressBornId != null) || (this.addressBornId != null && !this.addressBornId.equals(other.addressBornId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AddressBorn[addressBornId=" + addressBornId + "]";
    }
}
