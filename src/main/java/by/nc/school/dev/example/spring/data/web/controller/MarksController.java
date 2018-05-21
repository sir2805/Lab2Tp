package by.nc.school.dev.example.spring.data.web.controller;

import by.nc.school.dev.example.spring.data.model.*;
import by.nc.school.dev.example.spring.data.service.CourseService;
import by.nc.school.dev.example.spring.data.service.MarksService;
import by.nc.school.dev.example.spring.data.service.PersonService;
import by.nc.school.dev.example.spring.data.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Pages.JOURNAL.PATH_ABSOLUTE)
public class MarksController {

    protected PersonService personService;

    protected CourseService courseService;

    protected MarksService marksService;

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.ADD_LESSON.PATH)
    public String addLesson(HttpSession session,
                            @RequestParam(name = "lesson_name") String lessonName) {
        Course course = (Course) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        courseService.addLesson(course, lessonName);
        return "redirect:" + Pages.VIEWS.PUT_MARKS.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.PUT_MARK.PATH)
    public String putMark(HttpSession session,
                          @RequestParam(name = "lesson") String lesson,
                          @RequestParam(name = "student") String studentFullname,
                          @RequestParam(name = "mark") Integer markValue) {
        CourseMarks courseMarks = (CourseMarks) session.getAttribute(SessionAttributes.CURRENT_COURSE_MARKS);
        Student student = (Student) personService.getPersonByfullname(studentFullname);
        Course course = (Course) session.getAttribute(SessionAttributes.CURRENT_SUBJECT);
        Mark mark = new Mark(markValue);
        marksService.putMark(courseMarks, student, course, lesson, mark);
        return  "redirect:" + Pages.VIEWS.PUT_MARKS.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.JOURNAL.SELECT_SUBJECT.PATH)
    public String selectSubject(HttpSession session, HttpServletRequest request) {
//                                @RequestParam(value = "subject") String subjectName) {
        String stringSubjectId = request.getParameter("subjectbutton");
        session.setAttribute(SessionAttributes.CURRENT_SUBJECT, courseService.getSubjectById(Long.valueOf(stringSubjectId)));
        return "redirect:" + Pages.VIEWS.PUT_MARKS.PATH_ABSOLUTE;
    }

    @Required
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Required
    public void setMarksService(MarksService marksService) {
        this.marksService = marksService;
    }

    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
