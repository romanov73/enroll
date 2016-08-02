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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ru.ulstu.enroll.entity.person.Person;


@Entity
@Table(name = "student", catalog = "sp", schema = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"), 
    @NamedQuery(name = Student.FIND_CURRENT_ENROLL_YEAR, query = "SELECT s FROM Student s, StudentEdu e WHERE e.studentId=s and e.insertTime >= :beginPeriod ORDER BY s.person.surname, s.person.name, s.person.patronymic"), 
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId")
})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    public final static String FIND_CURRENT_ENROLL_YEAR = "Student.findCurrentEnrollYear";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id", nullable = false)
    private Integer studentId;
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
    
    @JoinColumn(name = "person_id", referencedColumnName ="person_id")
    @ManyToOne
    private Person person;
    @Column(name = "military_office", length = 150)
    private String militaryOffice;
    @Column(name = "hostel_require")
    private Boolean hostelRequire;
    @Column(name = "ul_school_num", length = 10)
    private String ulSchoolNum;
    @Column(name = "last_edu_year")
    private Integer lastEduYear;
    @Column(name = "training_year")
    private Integer trainingYear;
    @Column(name = "prize_name", length = 50)
    private String prizeName;
    @Column(name = "is_exam_list", length = 1)
    private String isExamList;
    @Column(name = "is_protokol", length = 1)
    private String isProtokol;
    @Column(name = "is_spec_match_profil", length = 1)
    private String isSpecMatchProfil;
    @Basic(optional = false)
    @Column(name = "photo_is_given", nullable = false)
    private Boolean photoIsGiven;
    @Column(name = "odines_id", length = 20)
    private String odinesId;
    @Column(name = "storage", length = 20)
    private String storage;
    @Column(name = "is_crimeans", length = 1)
    private String isCrimeans;
    @OneToMany(mappedBy = "studentId")
    private Collection<StudentEduDoc> studentEduDocCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentIndividualAchievem> studentIndividualAchievemCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private UmiidRegistration umiidRegistration;
    @JoinColumn(name = "edu_combination_id", referencedColumnName = "edu_combination_id")
    @ManyToOne
    private EduCombination eduCombinationId;
    @JoinColumn(name = "language_name", referencedColumnName = "language_name")
    @ManyToOne
    private EduLanguage languageName;
    @JoinColumn(name = "individual_achievement_id", referencedColumnName = "achievement_id")
    @ManyToOne
    private IndividualAchievement individualAchievementId;
    @JoinColumn(name = "prize_id", referencedColumnName = "prize_id")
    @ManyToOne
    private Prize prizeId;
    @JoinColumn(name = "training_id", referencedColumnName = "training_id")
    @ManyToOne
    private StudentTraining trainingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<StudentEdu> studentEduCollection;

    private String status;

    public Student() {
    }

    public Student(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getMilitaryOffice() {
        return militaryOffice;
    }

    public void setMilitaryOffice(String militaryOffice) {
        this.militaryOffice = militaryOffice;
    }

    public Boolean getHostelRequire() {
        return hostelRequire;
    }

    public void setHostelRequire(Boolean hostelRequire) {
        this.hostelRequire = hostelRequire;
    }

    public String getUlSchoolNum() {
        return ulSchoolNum;
    }

    public void setUlSchoolNum(String ulSchoolNum) {
        this.ulSchoolNum = ulSchoolNum;
    }

    public Integer getLastEduYear() {
        return lastEduYear;
    }

    public void setLastEduYear(Integer lastEduYear) {
        this.lastEduYear = lastEduYear;
    }

    public Integer getTrainingYear() {
        return trainingYear;
    }

    public void setTrainingYear(Integer trainingYear) {
        this.trainingYear = trainingYear;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getIsExamList() {
        return isExamList;
    }

    public void setIsExamList(String isExamList) {
        this.isExamList = isExamList;
    }

    public String getIsProtokol() {
        return isProtokol;
    }

    public void setIsProtokol(String isProtokol) {
        this.isProtokol = isProtokol;
    }

    public String getIsSpecMatchProfil() {
        return isSpecMatchProfil;
    }

    public void setIsSpecMatchProfil(String isSpecMatchProfil) {
        this.isSpecMatchProfil = isSpecMatchProfil;
    }

    public Boolean getPhotoIsGiven() {
        return photoIsGiven;
    }

    public void setPhotoIsGiven(Boolean photoIsGiven) {
        this.photoIsGiven = photoIsGiven;
    }

    public String getOdinesId() {
        return odinesId;
    }

    public void setOdinesId(String storage) {
        this.odinesId = odinesId;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getIsCrimeans() {
        return isCrimeans;
    }

    public void setIsCrimeans(String isCrimeans) {
        this.isCrimeans = isCrimeans;
    }

    public Collection<StudentEduDoc> getStudentEduDocCollection() {
        return studentEduDocCollection;
    }

    public void setStudentEduDocCollection(Collection<StudentEduDoc> studentEduDocCollection) {
        this.studentEduDocCollection = studentEduDocCollection;
    }

    public Collection<StudentIndividualAchievem> getStudentIndividualAchievemCollection() {
        return studentIndividualAchievemCollection;
    }

    public void setStudentIndividualAchievemCollection(Collection<StudentIndividualAchievem> studentIndividualAchievemCollection) {
        this.studentIndividualAchievemCollection = studentIndividualAchievemCollection;
    }

    public UmiidRegistration getUmiidRegistration() {
        return umiidRegistration;
    }

    public void setUmiidRegistration(UmiidRegistration umiidRegistration) {
        this.umiidRegistration = umiidRegistration;
    }

    public EduCombination getEduCombinationId() {
        return eduCombinationId;
    }

    public void setEduCombinationId(EduCombination eduCombinationId) {
        this.eduCombinationId = eduCombinationId;
    }

    public EduLanguage getLanguageName() {
        return languageName;
    }

    public void setLanguageName(EduLanguage languageName) {
        this.languageName = languageName;
    }

    public IndividualAchievement getIndividualAchievementId() {
        return individualAchievementId;
    }

    public void setIndividualAchievementId(IndividualAchievement individualAchievementId) {
        this.individualAchievementId = individualAchievementId;
    }

    public Prize getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Prize prizeId) {
        this.prizeId = prizeId;
    }

    public StudentTraining getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(StudentTraining trainingId) {
        this.trainingId = trainingId;
    }

    public Collection<StudentEdu> getStudentEduCollection() {
        return studentEduCollection;
    }

    public void setStudentEduCollection(Collection<StudentEdu> studentEduCollection) {
        this.studentEduCollection = studentEduCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "db.Student[studentId=" + studentId + "]";
    }

}
