/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "student_individual_achievem", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "StudentIndividualAchievem.findAll", query = "SELECT s FROM StudentIndividualAchievem s"), @NamedQuery(name = "StudentIndividualAchievem.findById", query = "SELECT s FROM StudentIndividualAchievem s WHERE s.id = :id"), @NamedQuery(name = "StudentIndividualAchievem.findByDocSeries", query = "SELECT s FROM StudentIndividualAchievem s WHERE s.docSeries = :docSeries"), @NamedQuery(name = "StudentIndividualAchievem.findByDocNumber", query = "SELECT s FROM StudentIndividualAchievem s WHERE s.docNumber = :docNumber"), @NamedQuery(name = "StudentIndividualAchievem.findByDocWhoIssued", query = "SELECT s FROM StudentIndividualAchievem s WHERE s.docWhoIssued = :docWhoIssued"), @NamedQuery(name = "StudentIndividualAchievem.findByYearDoc", query = "SELECT s FROM StudentIndividualAchievem s WHERE s.yearDoc = :yearDoc"), @NamedQuery(name = "StudentIndividualAchievem.findByBall", query = "SELECT s FROM StudentIndividualAchievem s WHERE s.ball = :ball")})
public class StudentIndividualAchievem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "doc_series", nullable = false, length = 20)
    private String docSeries;
    @Basic(optional = false)
    @Column(name = "doc_number", nullable = false, length = 20)
    private String docNumber;
    @Basic(optional = false)
    @Column(name = "doc_who_issued", nullable = false, length = 150)
    private String docWhoIssued;
    @Basic(optional = false)
    @Column(name = "year_doc", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date yearDoc;
    @Basic(optional = false)
    @Column(name = "ball", nullable = false)
    private int ball;
    @JoinColumn(name = "achievement_id", referencedColumnName = "achievement_id", nullable = false)
    @ManyToOne(optional = false)
    private IndividualAchievement achievementId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    @ManyToOne(optional = false)
    private Student studentId;

    public StudentIndividualAchievem() {
    }

    public StudentIndividualAchievem(Integer id) {
        this.id = id;
    }

    public StudentIndividualAchievem(Integer id, String docSeries, String docNumber, String docWhoIssued, Date yearDoc, int ball) {
        this.id = id;
        this.docSeries = docSeries;
        this.docNumber = docNumber;
        this.docWhoIssued = docWhoIssued;
        this.yearDoc = yearDoc;
        this.ball = ball;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDocWhoIssued() {
        return docWhoIssued;
    }

    public void setDocWhoIssued(String docWhoIssued) {
        this.docWhoIssued = docWhoIssued;
    }

    public Date getYearDoc() {
        return yearDoc;
    }

    public void setYearDoc(Date yearDoc) {
        this.yearDoc = yearDoc;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public IndividualAchievement getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(IndividualAchievement achievementId) {
        this.achievementId = achievementId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentIndividualAchievem)) {
            return false;
        }
        StudentIndividualAchievem other = (StudentIndividualAchievem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentIndividualAchievem[id=" + id + "]";
    }

}
