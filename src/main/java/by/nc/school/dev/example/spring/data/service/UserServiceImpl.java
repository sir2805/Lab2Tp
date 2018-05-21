package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Admin;
import by.nc.school.dev.example.spring.data.model.Person;
import by.nc.school.dev.example.spring.data.model.Role;
import by.nc.school.dev.example.spring.data.model.User;
import by.nc.school.dev.example.spring.data.persistence.UserRepository;
import by.nc.school.dev.example.spring.data.utils.TestDataGenerator;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    protected PersonService personService;

    protected TestDataGenerator testDataGenerator;

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User login(String login, String password) {
        User user = userRepository.findUserByUsername(login);

        if (user == null && "admin".equals(login)) {
            Person admin = new Admin("admin");
            user = new User("admin", "admin", admin);
            saveUser(user);
            testDataGenerator.prepareTestData();
        }
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUserByFullname(String fullname) {
        return userRepository.findUserByPersonFullname(fullname);
    }

    @Override
    public void changeUsername(Long userId, String newUsername) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setUsername(newUsername);
        userRepository.save(oldUser);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setPassword(newPassword);
        userRepository.save(oldUser);
    }

    @Override
    public void saveUser(String username, String password, Person person) {
        saveUser(new User(username, password, person));
    }

    @Override
    public User createUser(String username, String password, String fullname, String role) {
        Person person = personService.createPerson(fullname, role);
        return new User(username, password, person);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void changePerson(User user, Person person) {
        personService.removePerson(user.getPerson());
        user.setPerson(person);
        userRepository.save(user);
    }

    @Required
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Required
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Required
    public void setTestDataGenerator(TestDataGenerator testDataGenerator) {
        this.testDataGenerator = testDataGenerator;
    }
}
