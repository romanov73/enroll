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
@Table(name = "prize", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "Prize.findAll", query = "SELECT p FROM Prize p"), @NamedQuery(name = "Prize.findByInsertBy", query = "SELECT p FROM Prize p WHERE p.insertBy = :insertBy"), @NamedQuery(name = "Prize.findByUdateBy", query = "SELECT p FROM Prize p WHERE p.udateBy = :udateBy"), @NamedQuery(name = "Prize.findByInsertTime", query = "SELECT p FROM Prize p WHERE p.insertTime = :insertTime"), @NamedQuery(name = "Prize.findByUpdateTime", query = "SELECT p FROM Prize p WHERE p.updateTime = :updateTime"), @NamedQuery(name = "Prize.findByPrizeName", query = "SELECT p FROM Prize p WHERE p.prizeName = :prizeName"), @NamedQuery(name = "Prize.findByPrizeId", query = "SELECT p FROM Prize p WHERE p.prizeId = :prizeId")})
public class Prize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "insert_by", length = 50)
    private String insertBy;
    @Column(name = "udate_by", length = 50)
    private String udateBy;
    @Column(name = "insert_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Basic(optional = false)
    @Column(name = "prize_name", nullable = false, length = 50)
    private String prizeName;
    @Id
    @Basic(optional = false)
    @Column(name = "prize_id", nullable = false, length = 1)
    private String prizeId;
    @OneToMany(mappedBy = "prizeId")
    private Collection<Student> studentCollection;

    public Prize() {
    }

    public Prize(String prizeId) {
        this.prizeId = prizeId;
    }

    public Prize(String prizeId, String prizeName) {
        this.prizeId = prizeId;
        this.prizeName = prizeName;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public String getUdateBy() {
        return udateBy;
    }

    public void setUdateBy(String udateBy) {
        this.udateBy = udateBy;
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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prizeId != null ? prizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prize)) {
            return false;
        }
        Prize other = (Prize) object;
        if ((this.prizeId == null && other.prizeId != null) || (this.prizeId != null && !this.prizeId.equals(other.prizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Prize[prizeId=" + prizeId + "]";
    }

}
