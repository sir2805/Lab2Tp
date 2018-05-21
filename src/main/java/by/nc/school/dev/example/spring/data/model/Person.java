package by.nc.school.dev.example.spring.data.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "fullname", unique = true)
    protected String fullname;

    @Column(name = "role")
    protected int role;

    protected Person() {}

    public Person(String fullname, int role) {
//        this.id = UUID.randomUUID().getMostSignificantBits();
        this.fullname = fullname;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}
