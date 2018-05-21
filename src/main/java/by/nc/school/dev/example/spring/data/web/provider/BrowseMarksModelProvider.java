package by.nc.school.dev.example.spring.data.web.provider;

import by.nc.school.dev.example.spring.data.model.*;
import by.nc.school.dev.example.spring.data.persistence.ReportCardRepository;
import by.nc.school.dev.example.spring.data.web.controller.SessionAttributes;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by PC on 16-May-18.
 */
public class BrowseMarksModelProvider implements ModelProvider {

    protected ReportCardRepository reportCardRepository;

    @Override
    public void fillModel(Model model, HttpSession session) {
        Long currentStudentId = ((Person) session.getAttribute(SessionAttributes.CURRENT_PERSON)).getId();
        ReportCard reportCard = reportCardRepository.getReportCardByStudentId(currentStudentId);

        Map<Course, ListOfMarks> marks = reportCard.getMarksList();
        List<List<String>> marksTable = new ArrayList<>();
        List<List<String>> lessonsTable = new ArrayList<>();

        Set<Course> courses = new HashSet<>();
        for (Course course : marks.keySet()) {
            List<String> marksForStudent = new ArrayList<>();
            List<String> lessonsForStudent = new ArrayList<>();
            Map<String, Mark> marksMap = marks.get(course).getMarks();
            courses.add(course);
            for (String lesson : marksMap.keySet()) {
                lessonsForStudent.add(lesson);
                marksForStudent.add(String.valueOf(marksMap.get(lesson).getMark()));
            }
            lessonsTable.add(lessonsForStudent);
            marksTable.add(marksForStudent);
        }
        System.out.println(courses.size());
        fillModel(model, courses, marksTable, lessonsTable);
    }

    protected void fillModel(Model model, Set<Course> courses, List<List<String>> marksTable, List<List<String>> lessonsTable) {
        model.addAttribute("courses", courses);
        model.addAttribute("lessonsAndMarks", marksTable);
        model.addAttribute("lessonsForCourse", lessonsTable);
    }

    @Required
    public void setReportCardRepository(ReportCardRepository reportCardRepository) {
        this.reportCardRepository = reportCardRepository;
    }
}
