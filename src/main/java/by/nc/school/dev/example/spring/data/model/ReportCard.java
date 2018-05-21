package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "report_card")
public class ReportCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_list_of_marks",
            joinColumns = @JoinColumn(name = "report_card_id"),
            inverseJoinColumns = @JoinColumn(name = "list_of_marks_id"))
    @MapKeyColumn(name = "course_id")
    private Map<Course, ListOfMarks> marksList;

    public Long getId() {
        return id;
    }

    public ReportCard() {
        marksList = new HashMap<>();
    }

    public Map<Course, ListOfMarks> getMarksList() {
        return marksList;
    }

    public void setMarksList(Map<Course, ListOfMarks> marksList) {
        this.marksList = marksList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
