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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ru.ulstu.enroll.entity.BaseEntity;

/**
 *
 * @author osan
 */
@Entity
@Table(name = "person", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"), @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"), @NamedQuery(name = "Person.findByInsertBy", query = "SELECT p FROM Person p WHERE p.insertBy = :insertBy"), @NamedQuery(name = "Person.findByUpdateBy", query = "SELECT p FROM Person p WHERE p.updateBy = :updateBy"), @NamedQuery(name = "Person.findByInsertTime", query = "SELECT p FROM Person p WHERE p.insertTime = :insertTime"), @NamedQuery(name = "Person.findByUpdateTime", query = "SELECT p FROM Person p WHERE p.updateTime = :updateTime"), @NamedQuery(name = "Person.findBySex", query = "SELECT p FROM Person p WHERE p.sex = :sex"), @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname"), @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"), @NamedQuery(name = "Person.findByPatronymic", query = "SELECT p FROM Person p WHERE p.patronymic = :patronymic"), @NamedQuery(name = "Person.findByBirthDate", query = "SELECT p FROM Person p WHERE p.birthDate = :birthDate"), @NamedQuery(name = "Person.findByPhoto", query = "SELECT p FROM Person p WHERE p.photo = :photo")})
public class Person extends BaseEntity  {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
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
    @Column(name = "sex", length = 1)
    private String sex;
    @Basic(optional = false)
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "patronymic", length = 50)
    private String patronymic;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "photo")
    private Long photo;
    @JoinColumn(name = "address_born_id", referencedColumnName = "address_born_id")
    @ManyToOne
    private AddressBorn addressBornId;
    @JoinColumn(name = "address_reg_id", referencedColumnName = "address_reg_id")
    @ManyToOne
    private AddressReg addressRegId;
    @JoinColumn(name = "residence_id", referencedColumnName = "residence_id")
    @ManyToOne
    private Residence residenceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Doc> docCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonContact> personContactCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonSocStatus> personSocStatusCollection;

    public Person() {
    }

    public Person(Long personId) {
        this.personId = personId;
    }

    public Person(Long personId, String surname, String name) {
        this.personId = personId;
        this.surname = surname;
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPhoto() {
        return photo;
    }

    public void setPhoto(Long photo) {
        this.photo = photo;
    }

    public AddressBorn getAddressBornId() {
        return addressBornId;
    }

    public void setAddressBornId(AddressBorn addressBornId) {
        this.addressBornId = addressBornId;
    }

    public AddressReg getAddressRegId() {
        return addressRegId;
    }

    public void setAddressRegId(AddressReg addressRegId) {
        this.addressRegId = addressRegId;
    }

    public Residence getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Residence residenceId) {
        this.residenceId = residenceId;
    }

    public Collection<Doc> getDocCollection() {
        return docCollection;
    }

    public void setDocCollection(Collection<Doc> docCollection) {
        this.docCollection = docCollection;
    }

    public Collection<PersonContact> getPersonContactCollection() {
        return personContactCollection;
    }

    public void setPersonContactCollection(Collection<PersonContact> personContactCollection) {
        this.personContactCollection = personContactCollection;
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
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Person[personId=" + personId + "]";
    }
}
