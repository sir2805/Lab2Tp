package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;

@Entity
@Table(name = "tutor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tutor extends Person {

    @Column(name = "department")
    private String department;

    @Column(name = "duty")
    private String duty;

    public Tutor(String fullname) {
        this.fullname = fullname;
        this.department = Department.BMI;
        this.duty = Duty.PROFESSOR;
        this.role = Role.TUTOR;
    }

    public Tutor() {
        this.duty = Duty.PROFESSOR;
        this.role = Role.TUTOR;
    }

    public Tutor(String fullname, String department, String duty) {
        this.fullname = fullname;
        this.department = department;
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "department='" + department + '\'' +
                ", duty='" + duty + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
