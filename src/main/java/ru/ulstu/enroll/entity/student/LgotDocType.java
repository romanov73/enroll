/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author orion
 */
@Entity
@Table(name = "lgot_doc_type", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "LgotDocType.findAll", query = "SELECT l FROM LgotDocType l"), @NamedQuery(name = "LgotDocType.findByLgotDocTypeId", query = "SELECT l FROM LgotDocType l WHERE l.lgotDocTypeId = :lgotDocTypeId"), @NamedQuery(name = "LgotDocType.findByName", query = "SELECT l FROM LgotDocType l WHERE l.name = :name")})
public class LgotDocType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lgot_doc_type_id")
    private Long lgotDocTypeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgotDocTypeId")
    private Collection<LgotDoc> lgotDocCollection;

    public LgotDocType() {
    }

    public LgotDocType(Long lgotDocTypeId) {
        this.lgotDocTypeId = lgotDocTypeId;
    }

    public LgotDocType(Long lgotDocTypeId, String name) {
        this.lgotDocTypeId = lgotDocTypeId;
        this.name = name;
    }

    public Long getLgotDocTypeId() {
        return lgotDocTypeId;
    }

    public void setLgotDocTypeId(Long lgotDocTypeId) {
        this.lgotDocTypeId = lgotDocTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<LgotDoc> getLgotDocCollection() {
        return lgotDocCollection;
    }

    public void setLgotDocCollection(Collection<LgotDoc> lgotDocCollection) {
        this.lgotDocCollection = lgotDocCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgotDocTypeId != null ? lgotDocTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LgotDocType)) {
            return false;
        }
        LgotDocType other = (LgotDocType) object;
        if ((this.lgotDocTypeId == null && other.lgotDocTypeId != null) || (this.lgotDocTypeId != null && !this.lgotDocTypeId.equals(other.lgotDocTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LgotDocType[lgotDocTypeId=" + lgotDocTypeId + "]";
    }

}
