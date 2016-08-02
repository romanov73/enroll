/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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

/**
 *
 * @author orion
 */
@Entity
@Table(name = "lgot_doc", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "LgotDoc.findAll", query = "SELECT l FROM LgotDoc l"), @NamedQuery(name = "LgotDoc.findByInsertBy", query = "SELECT l FROM LgotDoc l WHERE l.insertBy = :insertBy"), @NamedQuery(name = "LgotDoc.findByUpdateBy", query = "SELECT l FROM LgotDoc l WHERE l.updateBy = :updateBy"), @NamedQuery(name = "LgotDoc.findByInsertTime", query = "SELECT l FROM LgotDoc l WHERE l.insertTime = :insertTime"), @NamedQuery(name = "LgotDoc.findByUpdateTime", query = "SELECT l FROM LgotDoc l WHERE l.updateTime = :updateTime"), @NamedQuery(name = "LgotDoc.findByLgotDocId", query = "SELECT l FROM LgotDoc l WHERE l.lgotDocId = :lgotDocId"), @NamedQuery(name = "LgotDoc.findByDocSeries", query = "SELECT l FROM LgotDoc l WHERE l.docSeries = :docSeries"), @NamedQuery(name = "LgotDoc.findByDocNumber", query = "SELECT l FROM LgotDoc l WHERE l.docNumber = :docNumber"), @NamedQuery(name = "LgotDoc.findByDocDate", query = "SELECT l FROM LgotDoc l WHERE l.docDate = :docDate"), @NamedQuery(name = "LgotDoc.findByWhoIssued", query = "SELECT l FROM LgotDoc l WHERE l.whoIssued = :whoIssued"), @NamedQuery(name = "LgotDoc.findByComment", query = "SELECT l FROM LgotDoc l WHERE l.comment = :comment")})
public class LgotDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "insert_by")
    private String insertBy;
    @Basic(optional = false)
    @Column(name = "update_by")
    private String updateBy;
    @Basic(optional = false)
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Basic(optional = false)
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lgot_doc_id")
    private Long lgotDocId;
    @Basic(optional = false)
    @Column(name = "doc_series")
    private String docSeries;
    @Basic(optional = false)
    @Column(name = "doc_number")
    private String docNumber;
    @Basic(optional = false)
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;
    @Basic(optional = false)
    @Column(name = "who_issued")
    private String whoIssued;
    @Column(name = "comment")
    private String comment;
    @OneToMany(mappedBy = "lgotDocId")
    private Collection<StudentEduLgot> studentEduLgotCollection;
    @JoinColumn(name = "lgot_doc_type_id", referencedColumnName = "lgot_doc_type_id")
    @ManyToOne(optional = false)
    private LgotDocType lgotDocTypeId;

    public LgotDoc() {
    }

    public LgotDoc(Long lgotDocId) {
        this.lgotDocId = lgotDocId;
    }

    public LgotDoc(Long lgotDocId, String insertBy, String updateBy, Date insertTime, Date updateTime, String docSeries, String docNumber, Date docDate, String whoIssued) {
        this.lgotDocId = lgotDocId;
        this.insertBy = insertBy;
        this.updateBy = updateBy;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
        this.docSeries = docSeries;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.whoIssued = whoIssued;
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

    public Long getLgotDocId() {
        return lgotDocId;
    }

    public void setLgotDocId(Long lgotDocId) {
        this.lgotDocId = lgotDocId;
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

    public String getWhoIssued() {
        return whoIssued;
    }

    public void setWhoIssued(String whoIssued) {
        this.whoIssued = whoIssued;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Collection<StudentEduLgot> getStudentEduLgotCollection() {
        return studentEduLgotCollection;
    }

    public void setStudentEduLgotCollection(Collection<StudentEduLgot> studentEduLgotCollection) {
        this.studentEduLgotCollection = studentEduLgotCollection;
    }

    public LgotDocType getLgotDocTypeId() {
        return lgotDocTypeId;
    }

    public void setLgotDocTypeId(LgotDocType lgotDocTypeId) {
        this.lgotDocTypeId = lgotDocTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgotDocId != null ? lgotDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LgotDoc)) {
            return false;
        }
        LgotDoc other = (LgotDoc) object;
        if ((this.lgotDocId == null && other.lgotDocId != null) || (this.lgotDocId != null && !this.lgotDocId.equals(other.lgotDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.LgotDoc[lgotDocId=" + lgotDocId + "]";
    }

}
