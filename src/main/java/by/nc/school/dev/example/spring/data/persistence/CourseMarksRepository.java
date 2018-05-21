package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.Course;
import by.nc.school.dev.example.spring.data.model.CourseMarks;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by PC on 16-May-18.
 */
public interface CourseMarksRepository extends JpaRepository<CourseMarks, Long> {

    CourseMarks getCourseMarksByCourse(Course course);
}

