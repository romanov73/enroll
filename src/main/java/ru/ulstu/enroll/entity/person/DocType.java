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
@Table(name = "doc_type", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "DocType.findAll", query = "SELECT d FROM DocType d"), @NamedQuery(name = "DocType.findByDocTypeId", query = "SELECT d FROM DocType d WHERE d.docTypeId = :docTypeId"), @NamedQuery(name = "DocType.findByDocTypeName", query = "SELECT d FROM DocType d WHERE d.docTypeName = :docTypeName"), @NamedQuery(name = "DocType.findByInsertBy", query = "SELECT d FROM DocType d WHERE d.insertBy = :insertBy"), @NamedQuery(name = "DocType.findByUpdateBy", query = "SELECT d FROM DocType d WHERE d.updateBy = :updateBy"), @NamedQuery(name = "DocType.findByInsertTime", query = "SELECT d FROM DocType d WHERE d.insertTime = :insertTime"), @NamedQuery(name = "DocType.findByUpdateTime", query = "SELECT d FROM DocType d WHERE d.updateTime = :updateTime")})
public class DocType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "doc_type_id", nullable = false, length = 1)
    private String docTypeId;
    @Basic(optional = false)
    @Column(name = "doc_type_name", nullable = false, length = 50)
    private String docTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docType")
    private Collection<Doc> docCollection;

    public DocType() {
    }

    public DocType(String docTypeId) {
        this.docTypeId = docTypeId;
    }

    public DocType(String docTypeId, String docTypeName) {
        this.docTypeId = docTypeId;
        this.docTypeName = docTypeName;
    }

    public String getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(String docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
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

    public Collection<Doc> getDocCollection() {
        return docCollection;
    }

    public void setDocCollection(Collection<Doc> docCollection) {
        this.docCollection = docCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docTypeId != null ? docTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocType)) {
            return false;
        }
        DocType other = (DocType) object;
        if ((this.docTypeId == null && other.docTypeId != null) || (this.docTypeId != null && !this.docTypeId.equals(other.docTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.DocType[docTypeId=" + docTypeId + "]";
    }

}
