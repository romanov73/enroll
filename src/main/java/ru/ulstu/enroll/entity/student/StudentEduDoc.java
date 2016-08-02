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
 * @author osan
 */
@Entity
@Table(name = "student_edu_doc", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "StudentEduDoc.findAll", query = "SELECT s FROM StudentEduDoc s"), @NamedQuery(name = "StudentEduDoc.findByInsertBy", query = "SELECT s FROM StudentEduDoc s WHERE s.insertBy = :insertBy"), @NamedQuery(name = "StudentEduDoc.findByUdateBy", query = "SELECT s FROM StudentEduDoc s WHERE s.udateBy = :udateBy"), @NamedQuery(name = "StudentEduDoc.findByInsertTime", query = "SELECT s FROM StudentEduDoc s WHERE s.insertTime = :insertTime"), @NamedQuery(name = "StudentEduDoc.findByUpdateTime", query = "SELECT s FROM StudentEduDoc s WHERE s.updateTime = :updateTime"), @NamedQuery(name = "StudentEduDoc.findByStudentEduDocId", query = "SELECT s FROM StudentEduDoc s WHERE s.studentEduDocId = :studentEduDocId"), @NamedQuery(name = "StudentEduDoc.findByEduDocSer", query = "SELECT s FROM StudentEduDoc s WHERE s.eduDocSer = :eduDocSer"), @NamedQuery(name = "StudentEduDoc.findByEduDocNum", query = "SELECT s FROM StudentEduDoc s WHERE s.eduDocNum = :eduDocNum"), @NamedQuery(name = "StudentEduDoc.findByEduDocOriginal", query = "SELECT s FROM StudentEduDoc s WHERE s.eduDocOriginal = :eduDocOriginal"), @NamedQuery(name = "StudentEduDoc.findByEduDocSpec", query = "SELECT s FROM StudentEduDoc s WHERE s.eduDocSpec = :eduDocSpec"), @NamedQuery(name = "StudentEduDoc.findByEduInstitutionName", query = "SELECT s FROM StudentEduDoc s WHERE s.eduInstitutionName = :eduInstitutionName")})
public class StudentEduDoc implements Serializable {
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
    @Id
    @Basic(optional = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_edu_doc_id", nullable = false)
    private Integer studentEduDocId;
    @Basic(optional = false)
    @Column(name = "edu_doc_ser", nullable = false, length = 50)
    private String eduDocSer;
    @Basic(optional = false)
    @Column(name = "edu_doc_num", nullable = false, length = 10)
    private String eduDocNum;
    @Basic(optional = false)
    @Column(name = "edu_doc_original", nullable = false)
    private boolean eduDocOriginal;
    @Column(name = "edu_doc_spec", length = 200)
    private String eduDocSpec;
    @Column(name = "edu_institution_name", length = 200)
    private String eduInstitutionName;
    @JoinColumn(name = "edu_doc_type_id", referencedColumnName = "edu_doc_type_id", nullable = false)
    @ManyToOne(optional = false)
    private EduDocType eduDocTypeId;
    @JoinColumn(name = "edu_institution_id", referencedColumnName = "edu_institution_id", nullable = false)
    @ManyToOne(optional = false)
    private EduInstitution eduInstitutionId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne
    private Student studentId;

    public StudentEduDoc() {
    }

    public StudentEduDoc(Integer studentEduDocId) {
        this.studentEduDocId = studentEduDocId;
    }

    public StudentEduDoc(Integer studentEduDocId, String eduDocSer, String eduDocNum, boolean eduDocOriginal) {
        this.studentEduDocId = studentEduDocId;
        this.eduDocSer = eduDocSer;
        this.eduDocNum = eduDocNum;
        this.eduDocOriginal = eduDocOriginal;
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

    public Integer getStudentEduDocId() {
        return studentEduDocId;
    }

    public void setStudentEduDocId(Integer studentEduDocId) {
        this.studentEduDocId = studentEduDocId;
    }

    public String getEduDocSer() {
        return eduDocSer;
    }

    public void setEduDocSer(String eduDocSer) {
        this.eduDocSer = eduDocSer;
    }

    public String getEduDocNum() {
        return eduDocNum;
    }

    public void setEduDocNum(String eduDocNum) {
        this.eduDocNum = eduDocNum;
    }

    public boolean getEduDocOriginal() {
        return eduDocOriginal;
    }

    public void setEduDocOriginal(boolean eduDocOriginal) {
        this.eduDocOriginal = eduDocOriginal;
    }

    public String getEduDocSpec() {
        return eduDocSpec;
    }

    public void setEduDocSpec(String eduDocSpec) {
        this.eduDocSpec = eduDocSpec;
    }

    public String getEduInstitutionName() {
        return eduInstitutionName;
    }

    public void setEduInstitutionName(String eduInstitutionName) {
        this.eduInstitutionName = eduInstitutionName;
    }

    public EduDocType getEduDocTypeId() {
        return eduDocTypeId;
    }

    public void setEduDocTypeId(EduDocType eduDocTypeId) {
        this.eduDocTypeId = eduDocTypeId;
    }

    public EduInstitution getEduInstitutionId() {
        return eduInstitutionId;
    }

    public void setEduInstitutionId(EduInstitution eduInstitutionId) {
        this.eduInstitutionId = eduInstitutionId;
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
        hash += (studentEduDocId != null ? studentEduDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEduDoc)) {
            return false;
        }
        StudentEduDoc other = (StudentEduDoc) object;
        if ((this.studentEduDocId == null && other.studentEduDocId != null) || (this.studentEduDocId != null && !this.studentEduDocId.equals(other.studentEduDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentEduDoc[studentEduDocId=" + studentEduDocId + "]";
    }

}
