package DP_Java.CourseManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_ANNOTATION")
public class Course1 {
    @Id
    private CoursePK Id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public CoursePK getId() {
        return Id;
    }

    public void setId(CoursePK id) {
        Id = id;
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
        return "Course1{" +
                "Id=" + Id +
                ", totalStudents=" + totalStudents +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
