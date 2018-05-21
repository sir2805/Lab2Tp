package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.*;
import by.nc.school.dev.example.spring.data.persistence.CourseMarksRepository;
import by.nc.school.dev.example.spring.data.persistence.ListOfMarksRepository;
import by.nc.school.dev.example.spring.data.persistence.ReportCardRepository;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

public class MarksServiceImpl implements MarksService {

    protected ListOfMarksRepository listOfMarksRepository;

    @Override
    public ListOfMarks initListOfMarks() {
        ListOfMarks listOfMarks = new ListOfMarks();
        listOfMarksRepository.save(listOfMarks);
        return listOfMarks;
    }

    @Override
    public void putMark(CourseMarks courseMarks, Student student, Course course, String lesson, Mark mark) {
        ListOfMarks studentMarks = courseMarks.getMarksList().get(student);
        studentMarks.getMarks().put(lesson, mark);
        listOfMarksRepository.save(studentMarks);
    }

    @Required
    public void setListOfMarksRepository(ListOfMarksRepository listOfMarksRepository) {
        this.listOfMarksRepository = listOfMarksRepository;
    }
}
