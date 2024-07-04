package DP_Java.CourseManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@IdClass(value = Course4.class)
@Entity
@Table(name = "COURSE_ANNOTATION")
public class Course4 implements Serializable {
    @Id
    private String title = null;

    @Id
    private String tutor = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
