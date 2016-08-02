/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ulstu.enroll.entity.student;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "individual_achievement", catalog = "sp", schema = "student")
@NamedQueries({@NamedQuery(name = "IndividualAchievement.findAll", query = "SELECT i FROM IndividualAchievement i"), @NamedQuery(name = "IndividualAchievement.findByAchievementId", query = "SELECT i FROM IndividualAchievement i WHERE i.achievementId = :achievementId"), @NamedQuery(name = "IndividualAchievement.findByAchievementName", query = "SELECT i FROM IndividualAchievement i WHERE i.achievementName = :achievementName")})
public class IndividualAchievement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "achievement_id", nullable = false)
    private Integer achievementId;
    @Column(name = "achievement_name", length = 100)
    private String achievementName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "achievementId")
    private Collection<StudentIndividualAchievem> studentIndividualAchievemCollection;
    @OneToMany(mappedBy = "individualAchievementId")
    private Collection<Student> studentCollection;

    public IndividualAchievement() {
    }

    public IndividualAchievement(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public Collection<StudentIndividualAchievem> getStudentIndividualAchievemCollection() {
        return studentIndividualAchievemCollection;
    }

    public void setStudentIndividualAchievemCollection(Collection<StudentIndividualAchievem> studentIndividualAchievemCollection) {
        this.studentIndividualAchievemCollection = studentIndividualAchievemCollection;
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
        hash += (achievementId != null ? achievementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndividualAchievement)) {
            return false;
        }
        IndividualAchievement other = (IndividualAchievement) object;
        if ((this.achievementId == null && other.achievementId != null) || (this.achievementId != null && !this.achievementId.equals(other.achievementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.IndividualAchievement[achievementId=" + achievementId + "]";
    }

}
