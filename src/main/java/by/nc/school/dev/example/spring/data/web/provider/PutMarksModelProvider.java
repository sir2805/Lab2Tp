package by.nc.school.dev.example.spring.data.web.provider;

import by.nc.school.dev.example.spring.data.model.*;
import by.nc.school.dev.example.spring.data.persistence.CourseMarksRepository;
import by.nc.school.dev.example.spring.data.service.CourseService;
import by.nc.school.dev.example.spring.data.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by PC on 16-May-18.
 */
public class PutMarksModelProvider implements ModelProvider {

    protected CourseMarksRepository courseMarksRepository;

    protected CourseService courseService;

    @Override
    public void fillModel(Model model, HttpSession session) {
        Person currentPerson = (Person) session.getAttribute(SessionAttributes.CURRENT_PERSON);

        List<Course> courses = courseService.getAllCourcesForTutor(currentPerson);
        Course currentCourse = (Course) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        if (currentCourse == null) {
            fillModel(model, courses, new ArrayList<>(), new HashSet<>(), new ArrayList<>());
            return;
        }
        CourseMarks courseMarks = courseMarksRepository.getCourseMarksByCourse(currentCourse);
        session.setAttribute(SessionAttributes.CURRENT_COURSE_MARKS, courseMarks);
        Set<String> lessons = courseMarks.getCourse().getLessonNames();
        Map<Student, ListOfMarks> marks = courseMarks.getMarksList();
        List<List<String>> marksTable = new ArrayList<>();

        List<Student> students = new ArrayList<>();
        for (Student student : marks.keySet()) {
            List<String> marksForStudent = new ArrayList<>();
            students.add(student);
            for (String lesson : lessons) {
                Mark mark = marks.get(student).getMarks().get(lesson);
                if (mark == null) {
                    marksForStudent.add(" ");
                }
                else {
                    marksForStudent.add(mark.toString());
                }
            }
            marksTable.add(marksForStudent);
        }
        fillModel(model, courses, students, lessons, marksTable);
    }

    protected void fillModel(Model model, List<Course> subjects, List<Student> students, Set<String> lessons, List<List<String>> marksTable) {
        model.addAttribute("subjects", subjects);
        model.addAttribute("students", students);
        model.addAttribute("lessons", lessons);
        model.addAttribute("lessonsAndMarks", marksTable);
    }
    @Required
    public void setCourseMarksRepository(CourseMarksRepository courseMarksRepository) {
        this.courseMarksRepository = courseMarksRepository;
    }

    @Required
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
