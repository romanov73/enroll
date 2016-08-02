/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ulstu.enroll.entity.student;

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

/**
 *
 * @author osan
 */
@Entity
@Table(name = "student_edu", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "StudentEdu.findAll", query = "SELECT s FROM StudentEdu s"), @NamedQuery(name = "StudentEdu.findByStudentEduId", query = "SELECT s FROM StudentEdu s WHERE s.studentEduId = :studentEduId"), @NamedQuery(name = "StudentEdu.findByInsertBy", query = "SELECT s FROM StudentEdu s WHERE s.insertBy = :insertBy"), @NamedQuery(name = "StudentEdu.findByUpdateBy", query = "SELECT s FROM StudentEdu s WHERE s.updateBy = :updateBy"), @NamedQuery(name = "StudentEdu.findByInsertTime", query = "SELECT s FROM StudentEdu s WHERE s.insertTime = :insertTime"), @NamedQuery(name = "StudentEdu.findByUpdateTime", query = "SELECT s FROM StudentEdu s WHERE s.updateTime = :updateTime"), @NamedQuery(name = "StudentEdu.findByGroupName", query = "SELECT s FROM StudentEdu s WHERE s.groupName = :groupName"), @NamedQuery(name = "StudentEdu.findByBaseEduId", query = "SELECT s FROM StudentEdu s WHERE s.baseEduId = :baseEduId"), @NamedQuery(name = "StudentEdu.findByEduNumberId", query = "SELECT s FROM StudentEdu s WHERE s.eduNumberId = :eduNumberId"), @NamedQuery(name = "StudentEdu.findByIsLeft", query = "SELECT s FROM StudentEdu s WHERE s.isLeft = :isLeft"), @NamedQuery(name = "StudentEdu.findByIsJoined", query = "SELECT s FROM StudentEdu s WHERE s.isJoined = :isJoined"), @NamedQuery(name = "StudentEdu.findByInYear", query = "SELECT s FROM StudentEdu s WHERE s.inYear = :inYear"), @NamedQuery(name = "StudentEdu.findByAdvantageJoin", query = "SELECT s FROM StudentEdu s WHERE s.advantageJoin = :advantageJoin"), @NamedQuery(name = "StudentEdu.findByPriority", query = "SELECT s FROM StudentEdu s WHERE s.priority = :priority"), @NamedQuery(name = "StudentEdu.findByBookNum", query = "SELECT s FROM StudentEdu s WHERE s.bookNum = :bookNum"), @NamedQuery(name = "StudentEdu.findByRegNum", query = "SELECT s FROM StudentEdu s WHERE s.regNum = :regNum")})
public class StudentEdu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_edu_id", nullable = false)
    private Integer studentEduId;
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
    @Column(name = "group_name", nullable = false, length = 13)
    private String groupName;
    @Basic(optional = false)
    @Column(name = "base_edu_id", nullable = false, length = 1)
    private String baseEduId;
    @Column(name = "edu_number_id")
    private Integer eduNumberId;
    @Column(name = "is_left")
    private Boolean isLeft;
    @Column(name = "is_joined")
    private Boolean isJoined;
    @Column(name = "in_year")
    private Integer inYear;
    @Column(name = "advantage_join")
    private Boolean advantageJoin;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "book_num", length = 10)
    private String bookNum;
    @Column(name = "reg_num", length = 20)
    private String regNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEdu")
    private Collection<StudentEduLgot> studentEduLgotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEdu")
    private Collection<StudentEduGrant> studentEduGrantCollection;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "student_status_name", referencedColumnName = "student_status_name", nullable = false)
    @ManyToOne(optional = false)
    private StudentStatus studentStatusName;
    @JoinColumn(name = "target_id", referencedColumnName = "target_id")
    @ManyToOne
    private Target targetId;

    public StudentEdu() {
    }

    public StudentEdu(Integer studentEduId) {
        this.studentEduId = studentEduId;
    }

    public StudentEdu(Integer studentEduId, String groupName, String baseEduId) {
        this.studentEduId = studentEduId;
        this.groupName = groupName;
        this.baseEduId = baseEduId;
    }

    public Integer getStudentEduId() {
        return studentEduId;
    }

    public void setStudentEduId(Integer studentEduId) {
        this.studentEduId = studentEduId;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBaseEduId() {
        return baseEduId;
    }

    public void setBaseEduId(String baseEduId) {
        this.baseEduId = baseEduId;
    }

    public Integer getEduNumberId() {
        return eduNumberId;
    }

    public void setEduNumberId(Integer eduNumberId) {
        this.eduNumberId = eduNumberId;
    }

    public Boolean getIsLeft() {
        return isLeft;
    }

    public void setIsLeft(Boolean isLeft) {
        this.isLeft = isLeft;
    }

    public Boolean getIsJoined() {
        return isJoined;
    }

    public void setIsJoined(Boolean isJoined) {
        this.isJoined = isJoined;
    }

    public Integer getInYear() {
        return inYear;
    }

    public void setInYear(Integer inYear) {
        this.inYear = inYear;
    }

    public Boolean getAdvantageJoin() {
        return advantageJoin;
    }

    public void setAdvantageJoin(Boolean advantageJoin) {
        this.advantageJoin = advantageJoin;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public Collection<StudentEduLgot> getStudentEduLgotCollection() {
        return studentEduLgotCollection;
    }

    public void setStudentEduLgotCollection(Collection<StudentEduLgot> studentEduLgotCollection) {
        this.studentEduLgotCollection = studentEduLgotCollection;
    }

    public Collection<StudentEduGrant> getStudentEduGrantCollection() {
        return studentEduGrantCollection;
    }

    public void setStudentEduGrantCollection(Collection<StudentEduGrant> studentEduGrantCollection) {
        this.studentEduGrantCollection = studentEduGrantCollection;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public StudentStatus getStudentStatusName() {
        return studentStatusName;
    }

    public void setStudentStatusName(StudentStatus studentStatusName) {
        this.studentStatusName = studentStatusName;
    }

    public Target getTargetId() {
        return targetId;
    }

    public void setTargetId(Target targetId) {
        this.targetId = targetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentEduId != null ? studentEduId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentEdu)) {
            return false;
        }
        StudentEdu other = (StudentEdu) object;
        if ((this.studentEduId == null && other.studentEduId != null) || (this.studentEduId != null && !this.studentEduId.equals(other.studentEduId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.StudentEdu[studentEduId=" + studentEduId + "]";
    }
}
