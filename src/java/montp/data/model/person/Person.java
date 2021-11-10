package montp.data.model.person;

import montp.data.model.ressource.Ressource;
import montp.data.model.security.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends User {

    public Person() { }

    public Person(String lastname, String firstname, String email, String userName, String password, Boolean isManager) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isManager = isManager;
    }

    private String lastname;
    private String firstname;
    private String email;
    private Boolean isManager;
    @OneToMany(mappedBy = "manager")
    private List<Ressource> ressources;

    public String getName() {
        return lastname;
    }

    public void setName(String lastname) {
        this.lastname = lastname;
    }

    public String getPrenom() {
        return firstname;
    }

    public void setPrenom(String firstname) { this.firstname = firstname; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getManager() { return isManager; }

    public void setManager(Boolean manager) { isManager = manager; }
}
