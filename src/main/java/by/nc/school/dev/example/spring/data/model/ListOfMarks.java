package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "list_of_marks")
public class ListOfMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ElementCollection
    @CollectionTable(name = "marks", joinColumns = @JoinColumn(name = "list_of_marks_id"))
    @MapKeyColumn(name = "lesson_name")
    @Column(name = "mark")
    private Map<String, Mark> marks;

    public Long getId() {
        return id;
    }

    public ListOfMarks() {
        this.marks = new HashMap<>();
    }

    public Map<String, Mark> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Mark> marks) {
        this.marks = marks;
    }
}
