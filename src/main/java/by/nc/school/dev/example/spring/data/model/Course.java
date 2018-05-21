package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_name", unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "lesson_names",
            joinColumns = @JoinColumn(name = "lesson_names_id")
    )
    private Set<String> lessonNames;

    private Course() {
        this.lessonNames = new HashSet<>();
    }

    public Course(String name) {
        this.name = name;
        this.lessonNames = new HashSet<>();
    }

    public Course(String name, Tutor tutor) {
        this.name = name;
        this.tutor = tutor;
        this.lessonNames = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Set<String> getLessonNames() {
        return lessonNames;
    }

    public void setLessonNames(Set<String> lessonNames) {
        this.lessonNames = lessonNames;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tutor != null ? tutor.hashCode() : 0);
        return result;
    }
}
