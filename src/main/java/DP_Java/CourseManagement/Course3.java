package DP_Java.CourseManagement;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_ANNOTATION")
public class Course3 {
    @EmbeddedId
    private CoursePK3 id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public Course3(String tutor, String title) {
        id = new CoursePK3(tutor, title);
    }

    public CoursePK3 getId() {
        return id;
    }

    public void setId(CoursePK3 id) {
        this.id = id;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return "Course3{" +
                "id=" + id +
                ", totalStudents=" + totalStudents +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
