package montp.data.model.ressource;

import montp.data.model.GenericEntity;
import montp.data.model.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "RESSOURCE")
public class Ressource extends GenericEntity {

    public Ressource () { }

    public Ressource(String label, Integer capacity, Boolean isShareable, RessourceType type, Person manager) {
        this.label = label;
        this.capacity = capacity;
        this.isShareable = isShareable;
        this.type = type;
        this.manager = manager;
    }

    private String label;
    private Integer capacity;
    private Boolean isShareable;
    @ManyToOne
    @JoinColumn(nullable = false)
    private RessourceType type;
    @ManyToOne
    private Person manager;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public RessourceType getType() { return this.type; }

    public void setType(RessourceType type) {
        this.type = type;
    }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Person getManager() { return manager; }

    public void setManager(Person manager) { this.manager = manager; }

}
