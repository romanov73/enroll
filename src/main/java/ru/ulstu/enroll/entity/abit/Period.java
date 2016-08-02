package ru.ulstu.enroll.entity.abit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author orion
 */
@Entity
@Table(name = "period", catalog = "sp", schema = "abit", uniqueConstraints = {@UniqueConstraint(columnNames = {"begin_date"})})
@NamedQueries({
    @NamedQuery(name = Period.FIND_ALL, query = "SELECT p.beginDate FROM Period p ORDER BY p.beginDate")
})
public class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    public final static String FIND_ALL = "Period.findAll";
    @Id
    @Basic(optional = false)
    @Column(name = "begin_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date beginDate;

    public Period() {
    }

    public Period(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beginDate != null ? beginDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.beginDate == null && other.beginDate != null) || (this.beginDate != null && !this.beginDate.equals(other.beginDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Period[beginDate=" + beginDate + "]";
    }

}
