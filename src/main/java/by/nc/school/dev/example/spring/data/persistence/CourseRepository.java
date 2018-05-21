package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String name);

    List<Course> findAllByTutor_Id(Long tutorId);
}
