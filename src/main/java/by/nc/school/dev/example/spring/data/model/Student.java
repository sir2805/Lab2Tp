package by.nc.school.dev.example.spring.data.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {

    public Student() {
    }

    public Student(String fullname) {
        super(fullname, Role.STUDENT);
    }
}
