package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "course_marks")
public class CourseMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_list_of_marks",
            joinColumns = @JoinColumn(name = "course_marks_id"),
            inverseJoinColumns = @JoinColumn(name = "list_of_marks_id"))
    @MapKeyColumn(name = "student_id")
    private Map<Student, ListOfMarks> marksList;

    public Long getId() {
        return id;
    }

    public CourseMarks() {
        marksList = new HashMap<>();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Map<Student, ListOfMarks> getMarksList() {
        return marksList;
    }

    public void setMarksList(Map<Student, ListOfMarks> marksList) {
        this.marksList = marksList;
    }
}
