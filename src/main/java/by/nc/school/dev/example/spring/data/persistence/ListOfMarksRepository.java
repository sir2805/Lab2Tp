package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.ListOfMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListOfMarksRepository extends JpaRepository<ListOfMarks, Long> {
}
