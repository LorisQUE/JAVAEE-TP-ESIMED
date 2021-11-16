package montp.services;

import montp.data.dao.PersonDAO;
import montp.data.model.person.Person;
import montp.tools.Tools;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonService extends GenericService<Person, PersonDAO> {

    public List<Person> getAll(){
        return dao.getAll();
    }

    @Transactional
    public void insert(Person person) {
        person.setName(person.getName().toUpperCase().trim());
        person.setPrenom(person.getPrenom().trim());
        person.setUserName(person.getUserName().trim());
        person.setEmail(person.getEmail().trim());
        person.setPassword(Tools.digestSHA256Hex(person.getPassword().trim()));
        super.insert(person);
    }

}
