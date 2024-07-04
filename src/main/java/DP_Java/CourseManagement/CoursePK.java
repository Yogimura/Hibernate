package DP_Java.CourseManagement;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CoursePK implements Serializable {
    private String tutor = null;
    private String title = null;

    public CoursePK() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursePK coursePK = (CoursePK) o;
        return Objects.equals(tutor, coursePK.tutor) && Objects.equals(title, coursePK.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, title);
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CoursePK{" +
                "tutor='" + tutor + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
