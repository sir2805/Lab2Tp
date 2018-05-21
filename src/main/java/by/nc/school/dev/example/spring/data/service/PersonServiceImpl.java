package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.*;
import by.nc.school.dev.example.spring.data.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Required;

public class PersonServiceImpl implements PersonService {

    protected PersonRepository<Person> personRepository;

    protected AppStringsService appStringsService;

    @Override
    public Person createPerson(String fullname, String role) {
        if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.STUDENT.KEY))) {
            return new Student(fullname);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.TUTOR.KEY))) {
            return new Tutor(fullname);
        } else if (role.equals(appStringsService.getString(AppStringsService.WEB.ADD_USER.PERSON.ROLE.ADMIN.KEY))) {
            return new Admin(fullname);
        } else {
            return null;
        }
    }

    @Override
    public Person getPersonByfullname(String fullname) {
        return personRepository.findByFullname(fullname);
    }

    @Override
    public void removePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Required
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Required
    public void setAppStringsService(AppStringsService appStringsService) {
        this.appStringsService = appStringsService;
    }
}
