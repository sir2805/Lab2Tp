package by.nc.school.dev.example.spring.data.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends Person {

    public Admin() {
    }

    public Admin(String fullname, int role) {
        super(fullname, role);
    }

    public Admin(String fullname) {
        this.fullname = fullname;
        this.role = Role.ADMIN;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "fullname='" + fullname + '\'' +
                ", role=" + role +
                '}';
    }
}
