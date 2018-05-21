package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {

    List<T> findAllByRole(int role);

    T findByFullname(String fullname);
}
