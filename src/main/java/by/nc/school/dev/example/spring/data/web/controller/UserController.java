package by.nc.school.dev.example.spring.data.web.controller;

import by.nc.school.dev.example.spring.data.model.Person;
import by.nc.school.dev.example.spring.data.model.Role;
import by.nc.school.dev.example.spring.data.model.User;
import by.nc.school.dev.example.spring.data.service.UserService;
import by.nc.school.dev.example.spring.data.utils.TestDataGenerator;
import by.nc.school.dev.example.spring.data.web.Pages;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Pages.USER.PATH_ABSOLUTE)
public class UserController {

    protected UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.LOGIN.PATH)
    public String login(HttpSession session
            ,@RequestParam("username") String username
            ,@RequestParam("password") String password) {
        User currentUser = userService.login(username, password);
        boolean isLoggedIn = currentUser != null;
        session.setAttribute(SessionAttributes.IS_LOGGED_IN, isLoggedIn);
        if (isLoggedIn) {
            Person currentPerson = currentUser.getPerson();
            session.setAttribute(SessionAttributes.CURRENT_PERSON, currentPerson);
            if (currentPerson.getRole() == Role.STUDENT) {
                return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
            } else {
                //TODO refactor using Spring convertor and UserViewModel
                return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
            }
        } else {
            return "redirect:" + Pages.VIEWS.HOME.PATH_ABSOLUTE;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = Pages.USER.LOGOUT.PATH)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:" + Pages.VIEWS.LOGIN.PATH_ABSOLUTE;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
