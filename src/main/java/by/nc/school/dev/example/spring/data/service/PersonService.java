package by.nc.school.dev.example.spring.data.service;

import by.nc.school.dev.example.spring.data.model.Person;

public interface PersonService {

    Person createPerson(String fullname, String role);

    Person getPersonByfullname(String fullname);

    void removePerson(Person person);

    void savePerson(Person person);
}
