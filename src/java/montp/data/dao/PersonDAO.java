package montp.data.dao;

import montp.data.model.person.Person;
import montp.data.model.ressource.Ressource;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonDAO extends GenericDAO<Person> {

    public PersonDAO() {
        super(Person.class);
    }

}
