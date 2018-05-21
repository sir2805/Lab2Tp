package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Person;
import by.nc.school.dev.example.spring.data.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User getUserByFullname(String fullname);

    User login(String login, String password);

    void changeUsername(Long userId, String newUsername);

    void changePassword(Long userId, String newPassword);

    void saveUser(User user);

    void changePerson(User user, Person person);

    void saveUser(String username, String password, Person person);

    User createUser(String username, String password, String fullname, String role);
}