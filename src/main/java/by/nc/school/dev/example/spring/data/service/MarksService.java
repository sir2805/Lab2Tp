package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.*;

public interface MarksService {

    ListOfMarks initListOfMarks();

    void putMark(CourseMarks courseMarks, Student student, Course course, String lesson, Mark mark);
}
