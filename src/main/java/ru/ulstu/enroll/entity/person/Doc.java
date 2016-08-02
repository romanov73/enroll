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

/**
 *
 * @author osan
 */
@Entity
@Table(name = "doc", catalog = "sp", schema = "person")
@NamedQueries({@NamedQuery(name = "Doc.findAll", query = "SELECT d FROM Doc d"), @NamedQuery(name = "Doc.findByDocTypeId", query = "SELECT d FROM Doc d WHERE d.docPK.docTypeId = :docTypeId"), @NamedQuery(name = "Doc.findByInsertBy", query = "SELECT d FROM Doc d WHERE d.insertBy = :insertBy"), @NamedQuery(name = "Doc.findByUpdateBy", query = "SELECT d FROM Doc d WHERE d.updateBy = :updateBy"), @NamedQuery(name = "Doc.findByInsertTime", query = "SELECT d FROM Doc d WHERE d.insertTime = :insertTime"), @NamedQuery(name = "Doc.findByUpdateTime", query = "SELECT d FROM Doc d WHERE d.updateTime = :updateTime"), @NamedQuery(name = "Doc.findByDocSeries", query = "SELECT d FROM Doc d WHERE d.docSeries = :docSeries"), @NamedQuery(name = "Doc.findByDocNumber", query = "SELECT d FROM Doc d WHERE d.docNumber = :docNumber"), @NamedQuery(name = "Doc.findByDocDate", query = "SELECT d FROM Doc d WHERE d.docDate = :docDate"), @NamedQuery(name = "Doc.findByDocWhoIssued", query = "SELECT d FROM Doc d WHERE d.docWhoIssued = :docWhoIssued"), @NamedQuery(name = "Doc.findByCitizenship", query = "SELECT d FROM Doc d WHERE d.citizenship = :citizenship"), @NamedQuery(name = "Doc.findByPersonId", query = "SELECT d FROM Doc d WHERE d.docPK.personId = :personId")})
public class Doc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocPK docPK;
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
    @Column(name = "doc_series", nullable = false, length = 20)
    private String docSeries;
    @Basic(optional = false)
    @Column(name = "doc_number", nullable = false, length = 20)
    private String docNumber;
    @Basic(optional = false)
    @Column(name = "doc_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date docDate;
    @Basic(optional = false)
    @Column(name = "doc_who_issued", nullable = false, length = 150)
    private String docWhoIssued;
    @Basic(optional = false)
    @Column(name = "citizenship", nullable = false, length = 20)
    private String citizenship;
    @JoinColumn(name = "doc_type_id", referencedColumnName = "doc_type_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DocType docType;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public Doc() {
    }

    public Doc(DocPK docPK) {
        this.docPK = docPK;
    }

    public Doc(DocPK docPK, String docSeries, String docNumber, Date docDate, String docWhoIssued, String citizenship) {
        this.docPK = docPK;
        this.docSeries = docSeries;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docWhoIssued = docWhoIssued;
        this.citizenship = citizenship;
    }

    public Doc(String docTypeId, int personId) {
        this.docPK = new DocPK(docTypeId, personId);
    }

    public DocPK getDocPK() {
        return docPK;
    }

    public void setDocPK(DocPK docPK) {
        this.docPK = docPK;
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

    public String getDocSeries() {
        return docSeries;
    }

    public void setDocSeries(String docSeries) {
        this.docSeries = docSeries;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocWhoIssued() {
        return docWhoIssued;
    }

    public void setDocWhoIssued(String docWhoIssued) {
        this.docWhoIssued = docWhoIssued;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
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
        hash += (docPK != null ? docPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doc)) {
            return false;
        }
        Doc other = (Doc) object;
        if ((this.docPK == null && other.docPK != null) || (this.docPK != null && !this.docPK.equals(other.docPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Doc[docPK=" + docPK + "]";
    }

}
