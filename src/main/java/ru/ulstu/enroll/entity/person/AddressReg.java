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
@Table(name = "address_reg", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "AddressReg.findAll", query = "SELECT a FROM AddressReg a"), @NamedQuery(name = "AddressReg.findByAddressRegId", query = "SELECT a FROM AddressReg a WHERE a.addressRegId = :addressRegId"), @NamedQuery(name = "AddressReg.findByInsertBy", query = "SELECT a FROM AddressReg a WHERE a.insertBy = :insertBy"), @NamedQuery(name = "AddressReg.findByUpdateBy", query = "SELECT a FROM AddressReg a WHERE a.updateBy = :updateBy"), @NamedQuery(name = "AddressReg.findByInsertTime", query = "SELECT a FROM AddressReg a WHERE a.insertTime = :insertTime"), @NamedQuery(name = "AddressReg.findByUpdateTime", query = "SELECT a FROM AddressReg a WHERE a.updateTime = :updateTime"), @NamedQuery(name = "AddressReg.findByAddressRegKorpus", query = "SELECT a FROM AddressReg a WHERE a.addressRegKorpus = :addressRegKorpus"), @NamedQuery(name = "AddressReg.findByAddressRegHouse", query = "SELECT a FROM AddressReg a WHERE a.addressRegHouse = :addressRegHouse"), @NamedQuery(name = "AddressReg.findByAddressRegFlat", query = "SELECT a FROM AddressReg a WHERE a.addressRegFlat = :addressRegFlat"), @NamedQuery(name = "AddressReg.findByAddressRegCountry", query = "SELECT a FROM AddressReg a WHERE a.addressRegCountry = :addressRegCountry"), @NamedQuery(name = "AddressReg.findByAddressRegKladrCode", query = "SELECT a FROM AddressReg a WHERE a.addressRegKladrCode = :addressRegKladrCode"), @NamedQuery(name = "AddressReg.findByAddressRegSubject", query = "SELECT a FROM AddressReg a WHERE a.addressRegSubject = :addressRegSubject"), @NamedQuery(name = "AddressReg.findByAddressRegRegion", query = "SELECT a FROM AddressReg a WHERE a.addressRegRegion = :addressRegRegion"), @NamedQuery(name = "AddressReg.findByAddressRegPunkt", query = "SELECT a FROM AddressReg a WHERE a.addressRegPunkt = :addressRegPunkt"), @NamedQuery(name = "AddressReg.findByAddressRegIndex", query = "SELECT a FROM AddressReg a WHERE a.addressRegIndex = :addressRegIndex"), @NamedQuery(name = "AddressReg.findByAddressRegStreet", query = "SELECT a FROM AddressReg a WHERE a.addressRegStreet = :addressRegStreet"), @NamedQuery(name = "AddressReg.findByAddressRegUlReg", query = "SELECT a FROM AddressReg a WHERE a.addressRegUlReg = :addressRegUlReg")})
public class AddressReg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "address_reg_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressRegId;
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
    @Column(name = "address_reg_korpus", length = 5)
    private String addressRegKorpus;
    @Column(name = "address_reg_house", length = 5)
    private String addressRegHouse;
    @Column(name = "address_reg_flat", length = 5)
    private String addressRegFlat;
    @Basic(optional = false)
    @Column(name = "address_reg_country", nullable = false, length = 50)
    private String addressRegCountry;
    @Basic(optional = false)
    @Column(name = "address_reg_kladr_code", nullable = false, length = 17)
    private String addressRegKladrCode;
    @Column(name = "address_reg_subject", length = 50)
    private String addressRegSubject;
    @Column(name = "address_reg_region", length = 50)
    private String addressRegRegion;
    @Column(name = "address_reg_punkt", length = 50)
    private String addressRegPunkt;
    @Column(name = "address_reg_index", length = 20)
    private String addressRegIndex;
    @Column(name = "address_reg_street", length = 50)
    private String addressRegStreet;
    @Column(name = "address_reg_ul_reg", length = 50)
    private String addressRegUlReg;
    @OneToMany(mappedBy = "addressRegId")
    private Collection<Person> personCollection;

    public AddressReg() {
    }

    public AddressReg(Integer addressRegId) {
        this.addressRegId = addressRegId;
    }

    public AddressReg(Integer addressRegId, String addressRegCountry, String addressRegKladrCode) {
        this.addressRegId = addressRegId;
        this.addressRegCountry = addressRegCountry;
        this.addressRegKladrCode = addressRegKladrCode;
    }

    public Integer getAddressRegId() {
        return addressRegId;
    }

    public void setAddressRegId(Integer addressRegId) {
        this.addressRegId = addressRegId;
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

    public String getAddressRegKorpus() {
        return addressRegKorpus;
    }

    public void setAddressRegKorpus(String addressRegKorpus) {
        this.addressRegKorpus = addressRegKorpus;
    }

    public String getAddressRegHouse() {
        return addressRegHouse;
    }

    public void setAddressRegHouse(String addressRegHouse) {
        this.addressRegHouse = addressRegHouse;
    }

    public String getAddressRegFlat() {
        return addressRegFlat;
    }

    public void setAddressRegFlat(String addressRegFlat) {
        this.addressRegFlat = addressRegFlat;
    }

    public String getAddressRegCountry() {
        return addressRegCountry;
    }

    public void setAddressRegCountry(String addressRegCountry) {
        this.addressRegCountry = addressRegCountry;
    }

    public String getAddressRegKladrCode() {
        return addressRegKladrCode;
    }

    public void setAddressRegKladrCode(String addressRegKladrCode) {
        this.addressRegKladrCode = addressRegKladrCode;
    }

    public String getAddressRegSubject() {
        return addressRegSubject;
    }

    public void setAddressRegSubject(String addressRegSubject) {
        this.addressRegSubject = addressRegSubject;
    }

    public String getAddressRegRegion() {
        return addressRegRegion;
    }

    public void setAddressRegRegion(String addressRegRegion) {
        this.addressRegRegion = addressRegRegion;
    }

    public String getAddressRegPunkt() {
        return addressRegPunkt;
    }

    public void setAddressRegPunkt(String addressRegPunkt) {
        this.addressRegPunkt = addressRegPunkt;
    }

    public String getAddressRegIndex() {
        return addressRegIndex;
    }

    public void setAddressRegIndex(String addressRegIndex) {
        this.addressRegIndex = addressRegIndex;
    }

    public String getAddressRegStreet() {
        return addressRegStreet;
    }

    public void setAddressRegStreet(String addressRegStreet) {
        this.addressRegStreet = addressRegStreet;
    }

    public String getAddressRegUlReg() {
        return addressRegUlReg;
    }

    public void setAddressRegUlReg(String addressRegUlReg) {
        this.addressRegUlReg = addressRegUlReg;
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
        hash += (addressRegId != null ? addressRegId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressReg)) {
            return false;
        }
        AddressReg other = (AddressReg) object;
        if ((this.addressRegId == null && other.addressRegId != null) || (this.addressRegId != null && !this.addressRegId.equals(other.addressRegId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.AddressReg[addressRegId=" + addressRegId + "]";
    }
}
