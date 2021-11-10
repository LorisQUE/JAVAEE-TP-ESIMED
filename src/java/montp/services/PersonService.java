package montp.services;

import montp.data.dao.PersonDAO;
import montp.data.model.person.Person;

import javax.transaction.Transactional;

public class PersonService extends GenericService<Person, PersonDAO> {

    @Transactional
    public void insert(Person person) {
        person.setName(person.getName());
        person.setPrenom(person.getPrenom());
        person.setUserName(person.getUserName());
        person.setEmail(person.getEmail());
        person.setPassword(person.getPassword());
        super.insert(person);
    }

}
