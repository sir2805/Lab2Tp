package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Course;
import by.nc.school.dev.example.spring.data.model.Person;
import by.nc.school.dev.example.spring.data.model.Tutor;
import by.nc.school.dev.example.spring.data.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    protected CourseRepository courseRepository;
    @Override
    public void addSubject(String name, Tutor tutor) {
        Course subject = new Course(name, tutor);
        courseRepository.save(subject);
    }

    @Override
    public Course getSubjectByName(String subjectName) {
        return courseRepository.findByName(subjectName);
    }

    @Override
    public void addLesson(Course course, String lesson) {
        course.getLessonNames().add(lesson);
        courseRepository.save(course);
    }

    @Override
    public Course getSubjectById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourcesForTutor(Person tutor) {
        return courseRepository.findAllByTutor_Id(tutor.getId());
    }

    @Required
    public void setCourseRepository(CourseRepository subjectRepository) {
        this.courseRepository = subjectRepository;
    }
}
