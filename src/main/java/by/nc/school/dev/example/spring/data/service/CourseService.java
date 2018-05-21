package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Course;
import by.nc.school.dev.example.spring.data.model.Person;
import by.nc.school.dev.example.spring.data.model.Tutor;

import java.util.List;

public interface CourseService {

    void addSubject(String name, Tutor tutor);

    Course getSubjectByName(String subjectName);

    void addLesson(Course course, String lesson);

    Course getSubjectById(Long id);

    List<Course> getAllCourcesForTutor(Person tutor);
}
