package DP_Java.Associations.Students;

import java.util.Set;
import java.util.stream.Collectors;

public class Course {
    private int id = 0;
    private String title = null;
    private Set<Student> students = null;

    public Course() {}

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course1{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", students=" + getStudents() +
                '}';
    }
}
