package by.nc.school.dev.example.spring.data.utils;

import by.nc.school.dev.example.spring.data.model.*;
import by.nc.school.dev.example.spring.data.persistence.CourseMarksRepository;
import by.nc.school.dev.example.spring.data.persistence.ReportCardRepository;
import by.nc.school.dev.example.spring.data.service.CourseService;
import by.nc.school.dev.example.spring.data.service.MarksService;
import by.nc.school.dev.example.spring.data.service.PersonService;
import by.nc.school.dev.example.spring.data.service.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 21-May-18.
 */
public class TestDataGenerator {

    UserService userService;

    PersonService personService;

    CourseService courseService;

    protected ReportCardRepository reportCardRepository;

    protected CourseMarksRepository courseMarksRepository;

    protected MarksService marksService;

    public void prepareTestData() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String login = "st" + i;
            String password = "pass";
            String studentName = "Student #" + i;
            userService.saveUser(new User(login, password, new Student(studentName)));
            Student student = (Student) personService.getPersonByfullname(studentName);
            studentList.add(student);
        }
        String login = "tutor";
        String password = "pass";
        String tutorName = "Tutor #1";
        userService.saveUser(new User(login, password, new Tutor(tutorName)));
        Tutor tutor = (Tutor) personService.getPersonByfullname(tutorName);
        Map<Student, Map<Course, ListOfMarks>> courseListOfMarksMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            Map<Student, ListOfMarks> studentListOfMarksMap = new HashMap<>();
            String courseName = "course # " + i;
            courseService.addSubject(courseName, tutor);
            Course course = courseService.getSubjectByName(courseName);
            for (Student student : studentList) {
                ListOfMarks listOfMarks = marksService.initListOfMarks();
                studentListOfMarksMap.put(student, listOfMarks);
                if (!courseListOfMarksMap.containsKey(student)) {
                    courseListOfMarksMap.put(student, new HashMap<>());
                }
                courseListOfMarksMap.get(student).put(course, listOfMarks);
            }
            initCourseMarks(course, studentListOfMarksMap);
        }
        for (Student student : studentList) {
            initReportCard(student, courseListOfMarksMap.get(student));
        }
    }

    public void initReportCard(Student student, Map<Course, ListOfMarks> marksList) {
        ReportCard reportCard = new ReportCard();
        reportCard.setStudent(student);
        reportCard.setMarksList(marksList);
        reportCardRepository.save(reportCard);
    }

    public void initCourseMarks(Course course, Map<Student, ListOfMarks> marksList) {
        CourseMarks courseMarks = new CourseMarks();
        courseMarks.setCourse(course);
        courseMarks.setMarksList(marksList);
        courseMarksRepository.save(courseMarks);
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    @Required
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
    @Required
    public void setReportCardRepository(ReportCardRepository reportCardRepository) {
        this.reportCardRepository = reportCardRepository;
    }
    @Required
    public void setCourseMarksRepository(CourseMarksRepository courseMarksRepository) {
        this.courseMarksRepository = courseMarksRepository;
    }
    @Required
    public void setMarksService(MarksService marksService) {
        this.marksService = marksService;
    }
}
