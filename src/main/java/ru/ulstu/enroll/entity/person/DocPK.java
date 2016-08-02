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
public class DocPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "doc_type_id", nullable = false, length = 1)
    private String docTypeId;
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private int personId;

    public DocPK() {
    }

    public DocPK(String docTypeId, int personId) {
        this.docTypeId = docTypeId;
        this.personId = personId;
    }

    public String getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(String docTypeId) {
        this.docTypeId = docTypeId;
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
        hash += (docTypeId != null ? docTypeId.hashCode() : 0);
        hash += (int) personId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocPK)) {
            return false;
        }
        DocPK other = (DocPK) object;
        if ((this.docTypeId == null && other.docTypeId != null) || (this.docTypeId != null && !this.docTypeId.equals(other.docTypeId))) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.DocPK[docTypeId=" + docTypeId + ", personId=" + personId + "]";
    }

}
