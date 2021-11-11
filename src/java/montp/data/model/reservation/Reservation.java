package montp.data.model.reservation;

import montp.data.model.GenericEntity;
import montp.data.model.person.Person;
import montp.data.model.ressource.Ressource;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation extends GenericEntity {

    public Reservation() { }

    public Reservation(Person person, Ressource ressource, Date dateStart, Date dateEnd, Integer personsCount) {
        this.person = person;
        this.ressource = ressource;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.personsCount = personsCount;
    }

    @ManyToOne
    private Person person;
    @ManyToOne
    private Ressource ressource;
    private Date dateStart;
    private Date dateEnd;
    private Integer personsCount; // Une réservation d'une ressource partageable doit indiquer le nombre de personne liées à cette réservation.

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }

    public Ressource getRessource() { return ressource; }

    public void setRessource(Ressource ressource) { this.ressource = ressource; }

    public Date getDateStart() { return dateStart; }

    public void setDateStart(Date dateStart) { this.dateStart = dateStart; }

    public Date getDateEnd() { return dateEnd; }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getPersonsCount() { return personsCount; }

    public void setPersonsCount(Integer personsCount) { this.personsCount = personsCount; }
}
