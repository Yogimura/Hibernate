package DP_Java.CourseManagement;

import java.io.Serializable;
import java.util.Objects;

public class CoursePK2 implements Serializable {
    private String tutor = null;
    private String title = null;

    public CoursePK2() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursePK2 coursePK2 = (CoursePK2) o;
        return Objects.equals(tutor, coursePK2.tutor) && Objects.equals(title, coursePK2.title);
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
        return "CoursePK2{" +
                "tutor='" + tutor + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
